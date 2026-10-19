<template>
  <div class="container-fluid py-3">
    <trial-balance-toolbar
        @refresh="reloadReport"
        @print="handlePrint"
        @export-csv="handleExportCsv"
        @export-pdf="handleExportPdf"
    />

    <trial-balance-filter
        v-model="filter"
        :period-options="periodOptions"
        @submit="loadReport"
    />

    <b-overlay :show="loading" rounded opacity="0.6" spinner-small spinner-variant="primary">
      <template v-if="reportLoaded">
        <trial-balance-period-info :period="report.period" />

        <trial-balance-summary-cards
            :total-debit="report.totalDebit"
            :total-credit="report.totalCredit"
        />

        <trial-balance-table
            :items="filteredLines"
            :total-debit="filteredTotalDebit"
            :total-credit="filteredTotalCredit"
            @drill-down="openLedger"
        />
      </template>

      <template v-else>
        <trial-balance-empty-state />
      </template>
    </b-overlay>
  </div>
</template>

<script>
import TrialBalanceService from './trialBalance.service';

import TrialBalanceToolbar from './TrialBalanceToolbar.vue';
import TrialBalanceFilter from './TrialBalanceFilter.vue';
import TrialBalancePeriodInfo from './TrialBalancePeriodInfo.vue';
import TrialBalanceSummaryCards from './TrialBalanceSummaryCards.vue';
import TrialBalanceTable from './TrialBalanceTable.vue';
import TrialBalanceEmptyState from './TrialBalanceEmptyState.vue';

export default {
  name: 'TrialBalanceReportPage',
  components: {
    TrialBalanceToolbar,
    TrialBalanceFilter,
    TrialBalancePeriodInfo,
    TrialBalanceSummaryCards,
    TrialBalanceTable,
    TrialBalanceEmptyState
  },
  data() {
    return {
      loading: false,
      reportLoaded: false,
      filter: {
        periodId: null,
        search: '',
        showZeroBalance: true
      },
      periodOptions: [
        { value: null, text: 'انتخاب کنید' }
      ],
      report: {
        period: null,
        lines: [],
        totalDebit: 0,
        totalCredit: 0
      }
    };
  },
  computed: {
    filteredLines() {
      let items = [...(this.report.lines || [])];

      if (!this.filter.showZeroBalance) {
        items = items.filter(i => Number(i.netBalance || 0) !== 0);
      }

      if (this.filter.search) {
        const q = this.filter.search.toLowerCase();
        items = items.filter(i =>
            String(i.accountCode || '').toLowerCase().includes(q) ||
            String(i.accountName || '').toLowerCase().includes(q)
        );
      }

      return items;
    },

    filteredTotalDebit() {
      return this.filteredLines.reduce((sum, x) => sum + Number(x.debitTotal || 0), 0);
    },

    filteredTotalCredit() {
      return this.filteredLines.reduce((sum, x) => sum + Number(x.creditTotal || 0), 0);
    }
  },

  created() {
    this.loadPeriods();
  },

  methods: {
    async loadPeriods() {
      try {
        const res = await TrialBalanceService.getAccountingPeriods();
        const items = Array.isArray(res.data) ? res.data : [];

        this.periodOptions = [
          { value: null, text: 'انتخاب کنید' },
          ...items.map(p => ({
            value: p.id,
            text: `${p.fiscalYear || ''} - ${p.periodName || ''}`
          }))
        ];
      } catch (e) {
        this.periodOptions = [
          { value: null, text: 'انتخاب کنید' },
          { value: 1, text: '1403 - فروردین' },
          { value: 2, text: '1403 - اردیبهشت' }
        ];
        this.toast('بارگذاری دوره‌ها با خطا مواجه شد', 'warning');
      }
    },

    async loadReport(payload) {
      const filter = payload || this.filter;

      if (!filter.periodId) {
        this.toast('لطفاً دوره مالی را انتخاب کنید', 'warning');
        return;
      }

      this.loading = true;
      try {
        const res = await TrialBalanceService.getTrialBalance(filter.periodId);

        this.report = {
          period: res.data.period || null,
          lines: Array.isArray(res.data.lines) ? res.data.lines : [],
          totalDebit: Number(res.data.totalDebit || 0),
          totalCredit: Number(res.data.totalCredit || 0)
        };

        this.reportLoaded = true;
      } catch (e) {
        this.toast('دریافت گزارش با خطا مواجه شد', 'danger');
      } finally {
        this.loading = false;
      }
    },

    reloadReport() {
      if (this.filter.periodId) {
        this.loadReport(this.filter);
      }
    },

    openLedger(item) {
      this.toast(`Drill-down برای حساب "${item.accountName}"`, 'info');
    },

    handlePrint() {
      window.print();
    },

    handleExportCsv() {
      if (!this.filteredLines.length) {
        this.toast('رکوردی برای خروجی وجود ندارد', 'warning');
        return;
      }

      const headers = ['کد حساب', 'نام حساب', 'جمع بدهکار', 'جمع بستانکار', 'مانده خالص'];

      const rows = this.filteredLines.map(x => [
        x.accountCode,
        x.accountName,
        x.debitTotal,
        x.creditTotal,
        x.netBalance
      ]);

      // نسخه اصلاح‌شده بدون اپراتور ??
      const csvContent = [headers, ...rows]
          .map(row =>
              row
                  .map(v => `"${String(v || '').replace(/"/g, '""')}"`)
                  .join(',')
          )
          .join('\n');

      const blob = new Blob(["\uFEFF" + csvContent], {
        type: 'text/csv;charset=utf-8;'
      });

      const url = URL.createObjectURL(blob);
      const link = document.createElement('a');
      link.href = url;
      link.setAttribute('download', 'trial-balance.csv');
      document.body.appendChild(link);
      link.click();
      document.body.removeChild(link);
    },

    handleExportPdf() {
      this.toast('برای خروجی PDF می‌توانید jsPDF اضافه کنید', 'secondary');
    },

    toast(message, variant = 'default') {
      this.$bvToast.toast(message, {
        title: 'تراز آزمایشی',
        variant,
        solid: true,
        autoHideDelay: 2500
      });
    }
  }
};
</script>

<style scoped>
@media print {
  .btn,
  .form-control,
  .custom-select,
  .card:first-child,
  .mb-3:first-child {
    display: none !important;
  }
}
</style>

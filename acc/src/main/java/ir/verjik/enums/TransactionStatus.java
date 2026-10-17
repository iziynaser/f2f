package ir.verjik.enums;

public enum TransactionStatus {

    // سند اولیه، قابل ویرایش، قابل حذف
    DRAFT,

    // سند ثبت شده، مانده‌ها اعمال شده، غیر قابل ویرایش
    POSTED,

    // قفل شده (مثلاً دوره بسته شده یا سند قطعی شده)
    LOCKED,

    // معکوس شده (سند Reverse ایجاد شده)
    REVERSED,

    // ابطال شده – ولی برای تاریخچه باقی می‌ماند
    CANCELLED
}

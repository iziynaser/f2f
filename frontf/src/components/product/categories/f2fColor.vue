<template>
    <div>

        <b-row class="my-1">
            <b-col sm="3">
                <b-form-select v-model="idx" :options="colorOptions" size="sm" class="mt-3">
                </b-form-select>                    
                <ul class="list-unstyled">
                    <li v-for="color in colors[idx].values" :key="color.name" @dblclick="addToSelectedColors(color)">                
                        <b-img rounded width="30" height="30" :blank-color="color.value" blank class="m-1"></b-img>
                        <span class="ql-align-right">{{color.name}}</span>
                    </li>
                </ul>
            </b-col>
            <b-col sm="9">
                <ul class="list-group-item-info">
                    <li v-for="color in selectedColors" :key="color.name" @dblclick="removeFromSelectedColors(color)">
                        <b-img rounded width="30" height="30" :blank-color="color.value" blank="true" class="m-1"></b-img>
                        <span class="ql-align-right">{{color.name}}</span>
                    </li>
                </ul>
            </b-col>
        </b-row>

    </div>
</template>

<script>
export default {
    name:'f2fColor',
    props:{
          } ,
    data(){
      return {
          idx: 0,
          selectedColors:[],
          colorOptions:[
              {value:0,text:this.$t('reds')},
              {value:1,text:this.$t('sooratiha')},
              {value:2,text:this.$t('narenji_ha')},
              {value:3,text:this.$t('zardha')},
              {value:4,text:this.$t('sabz_ha')},
              {value:5,text:this.$t('abi_ha')},
              {value:6,text:this.$t('banafsh_ha')},
              {value:7,text:this.$t('ghahveii_ha')},
              {value:8,text:this.$t('sefidha')},
              {value:9,text:this.$t('khakestariha')}
          ],
          colors:[
                    {
                        name: this.$t('reds'),
                        values:[
                            {name:this.$t('jigari'),value:"rgb(205 ,92 ,92)"},
                            {name:this.$t('ghermez'),value:"rgb(255 ,0 ,0)"},
                            {name:this.$t('sharabi'),value:"rgb(178 ,34 ,43)"},
                            {name:this.$t('anabi_tond'),value:"rgb(139 ,0 ,0)"},
                            {name:this.$t('hanaii_roshan'),value:"rgb(250 ,128 ,114)"},
                            {name:this.$t('ghahveii_hanaii'),value:"rgb(233 ,150 ,122)"}
                        ]
                    },
                    {
                        name:this.$t('sooratiha'),
                        values:[
                            {name:this.$t('soorati'),value:"rgb(255 ,192 ,203)"},
                            {name:this.$t('soorati_porrang'),value:"rgb(255, 182, 193)"},
                            {name:this.$t('sorkhabi'),value:"rgb(255 ,105 ,180)"},
                            {name:this.$t('shafaghi'),value:"rgb(255 , 20 ,147)"},
                            {name:this.$t('arghavani'),value:"rgb(199 , 21 , 133)"},
                        ]},
                    {
                        name:this.$t('narenji_ha'),
                        values:[
                            {name:this.$t('narenji_kerem'),value:"rgb(255 , 160 , 122)"},
                            {name:this.$t('narenji'),value:"rgb(255 , 165 , 0 )"},
                            {name:this.$t('narenji_sir'),value:"rgb(255 , 140 , 0)"},
                            {name:this.$t('narenji_porrang'),value:"rgb(255 , 127 , 80)"},
                            {name:this.$t('ghermez_gojeii'),value:"rgb(255 , 84 , 0)"},
                            {name:this.$t('ghermez_narenji'),value:"rgb(255 , 84 ,0)"},
                        ]},
                    {
                        name:this.$t('zardha'),
                        values:[
                            {name:this.$t('shiri'),value:"rgb(255 ,255 ,224)"},
                            {name:this.$t('shiri_shekari'),value:"rgb(255 ,250 ,205)"},
                            {name:this.$t('limoii_roshan'),value:"rgb(250 ,250 ,210)"},
                            {name:this.$t('holoii'),value:"rgb(255 ,228 ,181)"},
                            {name:this.$t('zard'),value:"rgb(255 ,255 ,0)"},
                            {name:this.$t('kahrobaii_baz'),value:"rgb(255 ,215, 0)"},
                            {name:this.$t('mashi'),value:"rgb(189 ,183 ,107)"},
                            {name:this.$t('nokhodi'),value:"rgb(238 ,232 ,170)"},
                    ]},
                    {
                        name:this.$t('sabz_ha'),
                        values:[
                            {name:this.$t('sabz_roshan'),value:"rgb(127 ,255 ,0)"},
                            {name:this.$t('sabz_kamrang'),value:"rgb(152 ,251 ,152)"},
                            {name:this.$t('sabz_keder'),value:"rgb(144 ,238 ,144)"},
                            {name:this.$t('sabz_chamani'),value:"rgb(50 ,205 ,50)"},
                            {name:this.$t('saz'),value:"rgb(0 ,128 ,0)"},
                            {name:this.$t('zeytooni'),value:"rgb(128 ,128 ,0)"},
                        ]},
                    {
                        name:this.$t('abi_ha'),
                        values:[
                            {name:this.$t('firoozei'),value:"rgb(255 ,255 ,0)"},
                            {name:this.$t('abi_kebriti'),value:"rgb(173 ,216 ,230)"},
                            {name:this.$t('abi'),value:"rgb(0 ,0 ,255)"},
                            {name:this.$t('sormeii'),value:"rgb(0 ,0 ,139)"},
                            {name:this.$t('lajvardi'),value:"rgb(0 ,0 ,128)"},
                            {name:this.$t('abi_nafti'),value:"rgb(25 ,25 ,112)"},
                            {name:this.$t('abi_asemani'),value:"rgb(224 ,255 ,255)"},
                    ]},
                    {
                        name:this.$t('banafsh_ha'),
                        values:[
                            {name:this.$t('nili kamrang'),value:"rgb(230 ,230 ,250)"},
                            {name:this.$t('sorkhabi'),value:"rgb(255 ,0 ,255)"},
                            {name:this.$t('orkideh'),value:"rgb(218 ,112 ,214)"},
                            {name:this.$t('makhmali'),value:"rgb(139 ,0 ,139)"},
                            {name:this.$t('banafsh'),value:"rgb(128 ,0 ,128)"},

                        ]},
                    {
                        name:this.$t('ghahveii_ha'),
                        values:[
                            {name:this.$t('kahi'),value:"rgb(255 ,248 ,220)"},
                            {name:this.$t('albalooii'),value:"rgb(128 ,0 ,0)"},
                            {name:this.$t('ghahveii'),value:"rgb(164 ,42 ,42)"},
                            {name:this.$t('kakaooii'),value:"rgb(139 ,69 ,19)"},
                            {name:this.$t('khardali'),value:"rgb(218 ,165 ,32)"},
                            {name:this.$t('mashi_sir'),value:"rgb(184 ,134 ,11)"},
                            {name:this.$t('bademjani'),value:"rgb(188 ,143 ,143)"},
                            {name:this.$t('kerem'),value:"rgb(255 ,228 ,196)"},
                        ]},
                    {
                        name:this.$t('sefidha'),
                        values:[
                            {name:this.$t('sefid'),value:"rgb(255 ,255 ,255)"},
                            {name:this.$t('sefid nanaii'),value:"rgb(245 ,255 ,250)"},
                            {name:this.$t('heli'),value:"rgb(245 ,245 ,220)"},
                            {name:this.$t('poost_piyazi'),value:"rgb(255 ,250 ,240)"},
                            {name:this.$t('ostekhani'),value:"rgb(255 ,255 ,240)"},
                            {name:this.$t('katani'),value:"rgb(250 ,240 ,230)"},
                            {name:this.$t('bej'),value:"rgb(255 ,228 ,225)"},
                        ]},
                    {
                        name:this.$t('khakestariha'),
                        values:[
                            {name:this.$t('meshki'),value:"rgb(0 ,0 ,0)"},
                            {name:this.$t('noghreii'),value:"rgb(211 ,211 ,211)"},
                            {name:this.$t('toosi'),value:"rgb(192 ,192 ,192)"},
                            {name:this.$t('khakestari_sir'),value:"rgb(169 ,169 ,169)"},
                            {name:this.$t('khakestari'),value:"rgb(128 ,128 ,128)"},
                            {name:this.$t('doodi'),value:"rgb(105 ,105 ,105)"},
                            {name:this.$t('sorbi'),value:"rgb(119 ,136 ,153)"},
                        ]}
                ]
        }
    } ,
    methods:{
        addToSelectedColors(color){
            let idx= this.selectedColors.indexOf(color);
            if(idx==-1)
                this.selectedColors.push(color);
        },
        removeFromSelectedColors(color){
            this.selectedColors = this.selectedColors.filter(element=>element.name!==color.name);
           // console.log(this.selectedColors)
        }
    }      
}
</script>


<style scoped>

</style>
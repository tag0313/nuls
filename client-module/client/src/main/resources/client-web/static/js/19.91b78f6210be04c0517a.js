webpackJsonp([19],{"9Hnk":function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var s=a("3cXf"),l=a.n(s),c=a("zsLt"),n=a.n(c),o=a("6ROu"),r=a.n(o),i=a("x47x"),m=a("LPk9"),d=a("FJop"),u=a("YgNb"),h=a("HhkY"),g={data:function(){var t=this;return{activeName:sessionStorage.getItem("CinfoActiveName")||"first",passChange:"delete",accountAddressValue:localStorage.getItem("newAccountAddress"),contractAddress:this.$route.query.address,balanceInfo:[],contractInfo:[],collectOk:!1,tradeData:[],pages:1,totalAll:0,contractData:[],contractItem:[],systemGas:0,callForm:{region:"",domains:[],gas:"",price:"",values:0,addtion:""},callRules:{gas:[{validator:function(e,a,s){a?a<1?(t.callForm.gas=1,s()):a>1e7?(t.callForm.gas=1e7,s()):s():s(new Error(t.$t("message.c204")))},trigger:"blur"}],price:[{validator:function(e,a,s){a?a<1?t.callForm.price=1:s():s(new Error(t.$t("message.c205")))},trigger:"blur"}],values:[{validator:function(e,a,s){a<0?t.callForm.values=0:Object(h.b)(a)?s():s(new Error(t.$t("message.c136")))},trigger:"blur"}]},callFormOptions:[],callSeniorValue:!1,switchDisabled:!1,valuesIf:!1,payableIf:!1,submitCallFormIf:!1,resultHash:"",submitCallFormSuccse:"",submitCallFormHight:0,decimals:0,isNrc20:!1,bigInteger:!1,contractInfoSetInterval:null}},components:{Back:m.a,Password:d.a},mounted:function(){var t=this;this.getContractInfo(this.contractAddress),this.getContractBalance(this.contractAddress),this.getContractTradeList(this.contractAddress),this.contractInfoSetInterval=setInterval(function(){setTimeout(function(){t.getContractBalance(t.contractAddress),t.getContractTradeList(t.contractAddress)},5e3),""!==t.resultHash&&t.getResultInfo(t.resultHash)},5e3)},destroyed:function(){clearInterval(this.contractInfoSetInterval)},methods:{handleClick:function(t){this.activeName=t.name,this.resultHash=""},getContractInfo:function(t){var e=this;this.$fetch("/contract/info/wallet/"+t+"?accountAddress="+this.accountAddressValue).then(function(t){if(t.success){t.data.createTxHashs=t.data.createTxHash.substr(0,10)+"..."+t.data.createTxHash.substr(-10),t.data.creaters=t.data.creater.substr(0,8)+"..."+t.data.creater.substr(-8),e.contractInfo=t.data;var a=0;for(var s in t.data.decimals&&(a=Object(u.d)(t.data.decimals),e.decimals=a),t.data.isNrc20&&(e.isNrc20=!0),t.data.method){if("<init>"===t.data.method[s].name||t.data.method[s].event||e.contractData.push(t.data.method[s]),t.data.method[s].args.length>0)for(var l in t.data.method[s].args)t.data.method[s].newArgs?t.data.method[s].newArgs=t.data.method[s].newArgs+t.data.method[s].args[l].name+" _"+t.data.method[s].args[l].type+",":t.data.method[s].newArgs=t.data.method[s].args[l].name+" _"+t.data.method[s].args[l].type+",";else t.data.method[s].newArgs=e.$t("message.c245");t.data.method[s].newArgs.length>0&&(t.data.method[s].newArgs=t.data.method[s].newArgs.substr(0,t.data.method[s].newArgs.length-1))}e.collectOk=e.accountAddressValue===t.data.creater,t.data.totalSupply&&(t.data.totalSupply=Object(u.l)(t.data.totalSupply,a))}else e.$message({message:e.$t("message.passWordFailed")+t.data.msg,type:"warning"})})},getContractBalance:function(t){var e=this;this.$fetch("/contract/balance/"+t).then(function(t){console.log(t),t.success?(t.data.balance=Object(u.m)(t.data.balance),t.data.locked=Object(u.m)(t.data.locked),t.data.usable=Object(u.m)(t.data.usable),e.balanceInfo=t.data):e.balanceInfo=[]})},collect:function(){var t=this,e="",a="";this.contractInfo.isCollect?(e="/contract/collection/cancel",a='{"accountAddress":"'+this.accountAddressValue+'","contractAddress":"'+this.contractAddress+'"}'):(e="/contract/collection",a='{"accountAddress":"'+this.accountAddressValue+'","contractAddress":"'+this.contractAddress+'","remarkName":""}'),this.$post(e,a).then(function(e){e.success?t.contractInfo.isCollect=!t.contractInfo.isCollect:t.$message({message:t.$t("message.passWordFailed")+e.data.msg,type:"warning"})})},deleteContract:function(){var t=this;this.passChange="delete","true"===localStorage.getItem("encrypted")?this.$refs.password.showPassword(!0):this.$confirm(this.$t("message.tip1"),"",{confirmButtonText:this.$t("message.confirmButtonText"),cancelButtonText:this.$t("message.cancelButtonText")}).then(function(){t.toSubmit("")}).catch(function(){console.log("")})},getContractTradeList:function(t){var e=this,a="/contract/tx/list/"+t+"?pageNumber="+this.pages+"&pageSize=15";this.$fetch(a).then(function(t){if(t.success){for(var a in e.totalAll=t.data.total,t.data.list)t.data.list[a].time=r()(Object(u.i)(t.data.list[a].time)).format("YYYY-MM-DD HH:mm:ss"),t.data.list[a].sender=r()(Object(u.i)(t.data.list[a].time)).format("YYYY-MM-DD HH:mm:ss");e.tradeData=t.data.list}else e.$message({message:e.$t("message.passWordFailed")+t.data.msg,type:"warning"})})},allConsensusSize:function(t){this.pages=t,this.getContractTradeList(this.contractAddress)},toNulscan:function(t){window.open("https://nulscan.io/accountInfo?address="+t,"_blank")},toTxid:function(t,e){this.$router.push({name:"dealInfo",query:{hash:t,type:e}})},changeCallOptions:function(t){for(var e in this.contractItem=t,this.payableIf=t.payable,this.$refs.callForm.resetFields(),this.callForm.domains=[],t.args){var a=new n.a(t.args[e].type);a.has("[")&&a.has("]")?t.args[e].types=this.$t("message.c241"):t.args[e].types="","BigInteger"===t.args[e].type?t.args[e].bigInteger=!0:t.args[e].bigInteger=!1}this.callForm.domains=t.args,this.callForm.region=t.name,this.valuesIf=t.view,this.submitCallFormIf=!1,this.submitCallFormSuccse="",this.resultHash="",t.view?(this.switchDisabled=!1,this.callSeniorValue=!1,this.systemCallGas=1,this.callForm.gas=1,this.callForm.price=1,this.callForm.values=0):(this.switchDisabled=!0,this.callSeniorValue=!1,this.systemCallGas="",this.callForm.gas="",this.callForm.price="",this.callForm.values=0),"BigInteger"===t.returnArg?this.bigInteger=!0:this.bigInteger=!1,t.args.length>0?this.callForm.domains=t.args:this.getCallGas(t)},getCallGas:function(t){var e=this,a="";t.view||(this.callForm.domains.length>0?Object(u.g)(this.callForm.domains).success&&(a='{"sender":"'+this.accountAddressValue+'","contractAddress":"'+this.contractAddress+'","value":"'+Object(u.e)(this.callForm.values)+'", "methodName":"'+t.name+'","methodDesc":"'+t.desc+'","price":"1","args":['+Object(u.g)(this.callForm.domains,this.decimals).params+"]}"):a='{"sender":"'+this.accountAddressValue+'","contractAddress":"'+this.contractAddress+'","value":"'+Object(u.e)(this.callForm.values)+'","methodName":"'+t.name+'","methodDesc":"'+t.desc+'","price":"1"}'),a&&this.$post("/contract/imputedgas/call",a).then(function(t){t.success?(e.systemGas=t.data.gasLimit,e.callForm.gas=t.data.gasLimit,e.getPrice(e.accountAddressValue),e.callForm.values=e.callForm.values||0):e.$message({message:e.$t("message.passWordFailed")+t.data.msg,type:"warning"})})},getPrice:function(t){var e=this,a='{"sender":"'+t+'"}';this.$post("/contract/imputedprice",a).then(function(t){t.success?e.callForm.price=t.data:e.$message({message:e.$t("message.passWordFailed")+t.data.msg,type:"warning"})})},submitCallForm:function(t){var e=this;this.$refs[t].validate(function(t){if(!t)return console.log("error submit!!"),!1;if(e.submitCallFormIf=!1,e.valuesIf){var a='{"contractAddress":"'+e.contractAddress+'","methodName":"'+e.contractItem.name+'","methodDesc":"'+e.contractItem.desc+'","args":['+Object(u.g)(e.callForm.domains,e.decimals).params+"]}";e.$post("/contract/view",a).then(function(t){if(t.success)if(e.submitCallFormIf=!0,e.submitCallFormHight=2,document.getElementById("out_pre").innerText="",e.isNrc20&&e.bigInteger){var a=new i.BigNumber(Object(u.a)(t.data.result,e.decimals).toString());document.getElementById("out_pre").innerText=a.toFormat().replace(/[,]/g,"")}else document.getElementById("out_pre").innerText=t.data.result;else e.$message({message:e.$t("message.passWordFailed")+t.data.msg,type:"warning"})})}else e.passChange="call","true"===localStorage.getItem("encrypted")?e.$refs.password.showPassword(!0):e.$confirm(e.$t("message.tip1"),"",{confirmButtonText:e.$t("message.confirmButtonText"),cancelButtonText:e.$t("message.cancelButtonText")}).then(function(){e.toSubmit("")}).catch(function(){console.log("")})})},toSubmit:function(t){var e=this,a="",s="";"call"===this.passChange?(a="/contract/call",s='{"sender":"'+this.accountAddressValue+'","gasLimit":'+this.callForm.gas+',"price":'+this.callForm.price+',"password":"'+t+'","remark":"'+Object(u.k)(this.callForm.addtion)+'","contractAddress":"'+this.contractAddress+'","value":"'+Object(u.e)(this.callForm.values||0).toString()+'","methodName":"'+this.contractItem.name+'","methodDesc":"'+this.contractItem.desc+'","args":['+Object(u.g)(this.callForm.domains,this.decimals).params+"]}"):(a="/contract/delete",s='{"sender":"'+this.accountAddressValue+'","contractAddress":"'+this.contractAddress+'","password":"'+t+'","remark":""}'),this.$post(a,s).then(function(t){t.success?"call"===e.passChange?(e.submitCallFormSuccse="",e.submitCallFormIf=!0,e.submitCallFormSuccse=t.data,e.resultHash=t.data,e.getResultInfo(t.data)):e.$router.push({name:"contract"}):e.$message({message:e.$t("message.passWordFailed")+t.data.msg,type:"warning"})})},getResultInfo:function(t){var e=this;this.$fetch("/contract/result/"+t).then(function(t){t.success?(document.getElementById("out_pre").innerText="",e.submitCallFormHight=0,t.data.flag?(e.submitCallFormHight=2,document.getElementById("out_pre").innerText="",document.getElementById("out_pre").innerText=l()(t.data.data,null,2),e.resultHash=""):e.submitCallFormSuccse=e.resultHash):e.$message({message:e.$t("message.passWordFailed")+t.data.msg,type:"warning"})})}},watch:{}},p={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"contract-info"},[a("Back",{attrs:{backTitle:this.$t("message.contract")}}),t._v(" "),a("div",{staticClass:"contract-info-top"},[a("div",{staticClass:"address"},[a("h3",[t._v(t._s(t.$t("message.c215"))+"："+t._s(this.contractAddress))]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:!this.collectOk&&"stop"!==this.contractInfo.status,expression:"!this.collectOk && this.contractInfo.status !=='stop'"}],staticClass:"cursor-p",on:{click:t.collect}},[t._v("\n          "+t._s(this.contractInfo.isCollect?t.$t("message.c2262"):t.$t("message.c2261"))+"\n          "),a("i",{staticClass:"el-icon-star-on",class:this.contractInfo.isCollect?"collects":"collect"})]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:this.collectOk&&"stop"!==this.contractInfo.status,expression:"this.collectOk && this.contractInfo.status !=='stop'"}],staticClass:"cursor-p",on:{click:t.deleteContract}},[t._v("\n          "+t._s(t.$t("message.c95"))+" "),a("i",{staticClass:"el-icon-delete"})]),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:"stop"===this.contractInfo.status,expression:"this.contractInfo.status ==='stop'"}]},[t._v(t._s(t.$t("message.c951"))+" ")])]),t._v(" "),a("ul",{staticClass:"info",class:this.contractInfo.isNrc20?"":"infos"},[a("li",[a("p",[a("span",[t._v(t._s(t.$t("message.tips4"))+"：")]),t._v(t._s(this.balanceInfo.balance)+" NULS")]),t._v(" "),a("p",{staticClass:"li-p"},[a("span",[t._v(t._s(t.$t("message.indexLock"))+"：")]),t._v(t._s(this.balanceInfo.locked)+"\n            NULS")]),t._v(" "),a("p",{staticClass:"li-p"},[a("span",[t._v(t._s(t.$t("message.indexUsable"))+"：")]),t._v(t._s(this.balanceInfo.usable)+"\n            NULS")])]),t._v(" "),a("li",[a("span",[t._v(t._s(t.$t("message.tips5"))+"：")]),t._v(t._s(this.totalAll)+" Txns")]),t._v(" "),a("li",{staticClass:"overflow"},[a("span",[t._v(t._s(t.$t("message.tips6"))+"：")]),t._v(" "),a("label",{staticClass:"cursor-p text-ds",on:{click:function(e){t.toNulscan(t.contractInfo.creater)}}},[t._v("\n            "+t._s(this.contractInfo.creaters)+"\n          ")]),t._v(" "),a("label",{staticClass:"labels"},[t._v("  at txid")]),t._v(" "),a("label",{staticClass:"overflow cursor-p text-ds",on:{click:function(e){t.toTxid(t.contractInfo.createTxHash,101)}}},[t._v("\n            "+t._s(this.contractInfo.createTxHashs)+"\n          ")])]),t._v(" "),a("li",{directives:[{name:"show",rawName:"v-show",value:this.contractInfo.isNrc20,expression:"this.contractInfo.isNrc20"}],staticClass:"overflow"},[a("span",[t._v("Token Tracker:")]),t._v("\n          "+t._s(this.contractInfo.nrc20TokenName)+"\n          "),a("font",{directives:[{name:"show",rawName:"v-show",value:this.contractInfo.nrc20TokenSymbol,expression:"this.contractInfo.nrc20TokenSymbol"}]},[t._v("("+t._s(this.contractInfo.nrc20TokenSymbol)+")")])],1),t._v(" "),a("li",{directives:[{name:"show",rawName:"v-show",value:this.contractInfo.isNrc20,expression:"this.contractInfo.isNrc20"}],staticClass:"overflow"},[a("span",[t._v(t._s(t.$t("message.tips8"))+":")]),t._v(t._s(this.contractInfo.totalSupply)+"\n        ")])])]),t._v(" "),a("el-tabs",{staticClass:"contract-info-tab",on:{"tab-click":t.handleClick},model:{value:t.activeName,callback:function(e){t.activeName=e},expression:"activeName"}},[a("el-tab-pane",{attrs:{label:t.$t("message.transactionRecord"),name:"first"}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.tradeData}},[a("el-table-column",{attrs:{label:t.$t("message.transactionType"),width:"120",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[t._v("\n              "+t._s(t.$t("message.type"+e.row.type))+"\n            ")]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"txData.data.sender",label:t.$t("message.c242"),"min-width":"150",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{directives:[{name:"show",rawName:"v-show",value:""!==e.row.txData.data.sender.toString(),expression:"scope.row.txData.data.sender.toString() !==''"}],staticClass:"cursor-p text-ds",on:{click:function(a){t.toNulscan(e.row.txData.data.sender)}}},[t._v("\n               "+t._s(e.row.txData.data.sender.substr(0,8))+"..."+t._s(e.row.txData.data.sender.substr(-8))+"\n\t\t\t\t\t\t\t\t")])]}}])}),t._v(" "),a("el-table-column",{attrs:{label:"txid","min-width":"180",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",{staticClass:"cursor-p text-ds",on:{click:function(a){t.toTxid(e.row.hash,e.row.type)}}},[t._v("\n                  "+t._s(e.row.hash.substr(0,10))+"..."+t._s(e.row.hash.substr(-10))+"\n\t\t\t\t\t\t\t\t")])]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"time",label:t.$t("message.time"),width:"145",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{label:t.$t("message.state"),align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(t.$t("message.statusS"+e.row.status)))])]}}])})],1),t._v(" "),a("el-pagination",{directives:[{name:"show",rawName:"v-show",value:t.totalAll>15,expression:"totalAll>15"}],staticClass:"cb",attrs:{layout:"prev, pager, next","page-size":15,total:t.totalAll,"current-page":t.pages},on:{"current-change":t.allConsensusSize}})],1),t._v(" "),a("el-tab-pane",{attrs:{label:t.$t("message.c243"),name:"second"}},[a("el-table",{staticStyle:{width:"100%"},attrs:{data:t.contractData}},[a("el-table-column",{attrs:{prop:"name",label:t.$t("message.c218"),width:"150",align:"center"}}),t._v(" "),a("el-table-column",{attrs:{prop:"newArgs",label:t.$t("message.c219"),"min-width":"200",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(t._s(""===e.row.newArgs?t.$t("message.c245"):e.row.newArgs))])]}}])}),t._v(" "),a("el-table-column",{attrs:{prop:"returnArg",label:t.$t("message.c220"),width:"150",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("span",[t._v(" ["+t._s(e.row.returnArg)+"]")])]}}])})],1)],1),t._v(" "),a("el-tab-pane",{attrs:{label:t.$t("message.type1011"),name:"third",disabled:"stop"===this.contractInfo.status}},[a("div",{staticClass:"query-info"},[a("el-form",{ref:"callForm",staticClass:"call-contract",attrs:{model:t.callForm,rules:t.callRules}},[a("el-form-item",{staticClass:"lable",attrs:{label:""}},[a("el-select",{attrs:{placeholder:t.$t("message.c229")},on:{change:t.changeCallOptions},model:{value:t.callForm.region,callback:function(e){t.$set(t.callForm,"region",e)},expression:"callForm.region"}},t._l(t.contractData,function(t){return a("el-option",{key:t.name,attrs:{label:t.name,value:t}})}))],1),t._v(" "),t._l(t.callForm.domains,function(e,s){return a("el-form-item",{key:e.name,attrs:{label:e.name+"( "+e.type+")"+e.types,prop:"domains."+s+".value",rules:{required:e.required,message:e.name+t.$t("message.c230"),trigger:"blur"}}},[a("el-input",{on:{change:function(e){t.getCallGas(t.contractItem)}},model:{value:e.value,callback:function(a){t.$set(e,"value","string"==typeof a?a.trim():a)},expression:"domain.value"}})],1)}),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:this.switchDisabled,expression:"this.switchDisabled"}],staticClass:"call-senior"},[t._v("\n              "+t._s(t.$t("message.c203"))+"\n              "),a("el-switch",{attrs:{width:35},model:{value:t.callSeniorValue,callback:function(e){t.callSeniorValue=e},expression:"callSeniorValue"}})],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.callSeniorValue,expression:"callSeniorValue"}],staticClass:"seniorInfo"},[a("el-form-item",{attrs:{label:"Gas Limit",prop:"gas"}},[a("el-tooltip",{attrs:{placement:"right"}},[a("div",{attrs:{slot:"content"},slot:"content"},[t._v(t._s(t.$t("message.c271")))]),t._v(" "),a("i",{staticClass:"el-icon-info tip_gas"})]),t._v(" "),a("el-input",{attrs:{onkeyup:"value=value.replace(/[^\\d]/g,'')"},model:{value:t.callForm.gas,callback:function(e){t.$set(t.callForm,"gas",e)},expression:"callForm.gas"}}),t._v(" "),a("p",{directives:[{name:"show",rawName:"v-show",value:this.callForm.gas<this.systemGas&&this.callForm.gas>0,expression:"this.callForm.gas < this.systemGas && this.callForm.gas > 0"}],staticClass:"price-min"},[t._v("\n                  "+t._s(t.$t("message.c206")))])],1),t._v(" "),a("el-form-item",{attrs:{label:"Price",prop:"price"}},[a("el-tooltip",{attrs:{placement:"right"}},[a("div",{attrs:{slot:"content"},slot:"content"},[t._v(t._s(t.$t("message.c272")))]),t._v(" "),a("i",{staticClass:"el-icon-info tip_price"})]),t._v(" "),a("el-input",{attrs:{onkeyup:"value=value.replace(/[^\\d]/g,'')"},model:{value:t.callForm.price,callback:function(e){t.$set(t.callForm,"price",e)},expression:"callForm.price"}})],1),t._v(" "),a("el-form-item",{directives:[{name:"show",rawName:"v-show",value:t.payableIf,expression:"payableIf"}],attrs:{label:"Value",prop:"values"}},[a("el-tooltip",{attrs:{placement:"right"}},[a("div",{attrs:{slot:"content"},slot:"content"},[t._v(t._s(t.$t("message.c273")))]),t._v(" "),a("i",{staticClass:"el-icon-info tip_value"})]),t._v(" "),a("el-input",{attrs:{onkeyup:"value=value.replace(/[^0-9.]/g,'')",maxlength:17},on:{change:function(e){t.getCallGas(t.contractItem)}},model:{value:t.callForm.values,callback:function(e){t.$set(t.callForm,"values",e)},expression:"callForm.values"}})],1),t._v(" "),a("el-form-item",{attrs:{label:t.$t("message.tips3"),prop:"addtion"}},[a("el-input",{attrs:{maxlength:30},model:{value:t.callForm.addtion,callback:function(e){t.$set(t.callForm,"addtion",e)},expression:"callForm.addtion"}})],1)],1),t._v(" "),a("el-form-item",{staticClass:"submit-bt",staticStyle:{"text-align":"center"}},[a("el-button",{attrs:{type:"primary"},on:{click:function(e){t.submitCallForm("callForm")}}},[t._v(t._s(t.$t("message.c231")))])],1)],2),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.submitCallFormIf,expression:"submitCallFormIf"}],staticClass:"click-after scroll"},[a("p",{class:this.submitCallFormHight<=1?"waingClass":""},[a("span",{directives:[{name:"show",rawName:"v-show",value:this.submitCallFormHight<=1,expression:"this.submitCallFormHight <= 1"}],staticClass:"overflow"},[t._v("TxID:"+t._s(this.submitCallFormSuccse)+" "+t._s(t.$t("message.confirming"))+"....")]),t._v(" "),a("span",{directives:[{name:"show",rawName:"v-show",value:this.submitCallFormHight>1,expression:"this.submitCallFormHight > 1"}],staticClass:"cursor-p text-ds overflow",on:{click:function(e){t.toTxid(t.submitCallFormSuccse,100)}}},[t._v(t._s(this.submitCallFormSuccse))])]),t._v(" "),a("pre",{attrs:{id:"out_pre"}})])],1)])],1),t._v(" "),a("Password",{ref:"password",on:{toSubmit:t.toSubmit}})],1)},staticRenderFns:[]};var v=a("vSla")(g,p,!1,function(t){a("NemG")},null,null);e.default=v.exports},NemG:function(t,e){}});
<template>
   <div class="container navbar-offset-top">
      <EditModel v-on:closeSingleContent="closeSingleContent()"" v-if="showAddFormContent" />
      <div class="row">
        <section class="col-12 section_header">
          <h1>Model: {{model}}</h1>
        </section>
      <table class="table table-hover">
        <tr class="header_table_hover">
          <th  v-for="(value, key) in records[0]">{{addKey(key)}}</th>
          <th>Delete</th>
          <th>Edit</th>
        </tr>
         <tr class="header_table">
          <th  v-for="value in keys">{{value}}</th>
          <th>Delete</th>
          <th>Edit</th>
        </tr>
        <tr v-for="record in records">
          <td v-for="key in keys">{{record[key]}} </td>
          <td><span class="delete_button" v-on:click="deleteRecord(record[keys[0]])">Delete</span></td>
          <td><span v-if="!isShopingCart" class="edit_button" v-on:click="editRecord(record)">Edit</span></td>
        </tr>
      </table>
      <h2>Add new record</h2>
      <form class="form-add align-center custom-padding">
        <div v-for="key in keys" class="input-fileds">   
          <label>{{key}}</label>
          <input type="text" v-model="params[key]"/>
        </div>
        <span class="u-full-width add_button" v-on:click="addModel()" >Add</span>
      </form>
      </div>
    </div>
</template>

<script>

import axios from 'axios';
import EditModel from './EditModel.vue';

export default {
  name: 'Model',
  components: {
    EditModel
  },
  data () {
    return {
      records: [],
      params: [],
      keys: [],
      isShopingCart: false,
      model: this.$route.params.model,
      showAddFormContent: false,
    }
  },
  methods: {
      closeSingleContent(){
        this.showAddFormContent = false;
        this.getRecords();
      },
      editRecord(recordTemp){
       this.$store.commit("setRecord", {
          record: recordTemp
        })
         this.$store.commit("setKeys", {
          keys: this.keys
        })
        this.showAddFormContent = true;
      },
      addModel(){
        let modelTemp = {};

        for(let i=1;i<this.keys.length;i++){
          modelTemp[this.keys[i]] =  this.params[this.keys[i]];
          
          console.log(modelTemp[this.keys[i]]);

        }
        if(this.model ==="Category"){
           
            modelTemp['products'] = JSON.parse("[" +  modelTemp['products'] + "]");;
        }
        if(this.model ==="ShoppingCart"){
           
            modelTemp['items'] = JSON.parse("[" +  modelTemp['items'] + "]");;
        }
        if(this.model ==="Product"){
          //modelTemp['PRODUCTS_INTEGER_IDX'] = 15;
        }
        if(this.model ==="CartItem"){
          //modelTemp['ITEMS_INTEGER_IDX'] = 2;
        }

        console.log(modelTemp);
        axios.post('http://localhost:8090/'+this.model +'/save', modelTemp).then((response) =>{
          alert("Record was added!");
          this.getRecords();
        })
        .catch(function(error){
          alert("Sth went wrong!");
        }.bind(this));
      },
      addKey(key){
      if((this.model === "ShopProduct" && (key==="product" || key==="shop")) || (this.model === "ShoppingCart" && (key==="person"))){
      
      }else{
        if( this.block !=1){
          if(key === this.keys[0]){
            this.block= 1;
          }else{
            this.keys.push(key);
          }
          }
        }
      },
      deleteRecord(id){
       axios.get('http://localhost:8090/'+this.model +'/delete/'+ id)
       .then(function (response) {
       this.getRecords();
       alert("Record was deleted!");

      }.bind(this))
      .catch((error)=>{
        this.$router.push('/start'); 
         alert("Sth went wrong!");
      });
     },
      getRecords(){
        console.log(this.model);
        axios.get('http://localhost:8090/'+this.model+'/findAll')
        .then(function (response) {
            this.records = response.data;
        }.bind(this))
        .catch((error)=>{
          this.$router.push('/start'); 
        });
      },
    
  },
  created: function () {
    this.getRecords();

     if(this.model ==="ShoppingCart"){
      this.isShopingCart = true;
     }
  },
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped lang="scss">

@import '@/styles/variables.scss';

h1{
  margin: 50px 0;
  font-size: 3em;
}
h2{
  margin-bottom: 20px;
  font-size: 2.2em;
  text-align: center;
  display: block;
  width: 100%;
}
.delete_button, .edit_button{
  color: red;
  cursor: pointer;
}
.edit_button{
  color: #a3a05b;
}
.header_table_hover{
  display: none;
}
.button_show_frequence{
  display: block;
  width: 100%;
  text-align: right;
  width: auto;
  cursor: pointer;
  position: relative;
}
form{
  width: 100%;
}
.input-fileds:first-child{
  display: none;
}
.input-fileds{
  display: block;
  width: 100%;
  text-align: center;
  position: relative;

  label{
    display: block;
    text-align: center;
    width: 100%;
  }

  input{
    display: table;
    margin: 0 auto;
  }
}

</style>

<template>
  <div class="single_content">
    <div class="center_content">
      <span class="close_btn" v-on:click="closeBtn()">&times;</span>
       <h2>Edit Model:</h2>
        <form class="form-add align-center custom-padding">
          <div v-for="key in keys" class="input-fileds">   
            <label>{{key}}</label>
            <input type="text" v-model="record[key]"/>
          </div>
          <span class="u-full-width add_button" v-on:click="editModel()" >Add</span>
        </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios';


  export default {
    name: 'EditModel',
    data() {
      return {
        keys: [],
        record: null,
        model: this.$route.params.model,
      }
    },
    methods: {
      closeBtn(){
          this.$emit('closeSingleContent');
      },
      editModel(){
        axios.post('http://localhost:8090/'+this.model +'/update', this.record).then((response) =>{
            alert("Record was edited!");
             this.$emit('closeSingleContent');
          })
          .catch(function(error){
            alert("Sth went wrong!");
          }.bind(this));
      }
    },
    created: function(){
     this.keys = this.$store.getters.getKeys;
      this.record = this.$store.getters.getRecord;
      console.log(this.keys);
      console.log(this.record);
      if(this.model ==="Category"){
        this.keys.splice(0,2);
      }else{
        this.keys.splice(0,1);
      }
    }
  }
</script>

<style scoped lang="scss">

@import '@/styles/variables.scss';
h1{
  font-size: 2.5em;  
  span{
    float: right;
    font-size: 0.7em;
    line-height: 2em;
    vertical-align: bottom;
  }
}

.single_content{
  padding-top: 75px;
  padding-left: 30px;
  padding-right: 30px;
  position: absolute;
  min-height: 100vh;
  width: 100%;
  margin: 0 auto;
  right: 0;
  top: 0;
  left: 0;
  background-color: $dark_grey;
  z-index: 5;
  display: flex;
  align-items: center;
  justify-content: center;

  .center_content{
    padding: 50px;
  }

  .form-add{
    text-align: center;

    input, textarea, select{
      width: 100%;
      max-width: 600px;
      text-align: center;
    }

    .add_button{
      display: block;
      margin: 0 auto;
      margin-top: 20px;
    }
  }
}

.close_btn{
  position: absolute;
  right: 30px;
  top: 105px;
  font-size: 4em;
  line-height: 0;
  cursor: pointer;
  z-index: 999;
}


</style>

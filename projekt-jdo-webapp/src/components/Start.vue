<template>
  <div class="w100 background_login">
    <div class="container">
      <div class="row">
        <h1>Chose tables for API configuration</h1>
        <div class="col-12 menu">	
        	<div class="checkbox_group" v-for="sequence in sequences">
	          	<input type="checkbox"  v-bind:value="sequence.sequence_NAME" v-model="selectedSequences">
				      <label v-bind:for="sequence.sequence_NAME">{{sequence.sequence_NAME.split('.')[sequence.sequence_NAME.split('.').length-1]}}</label>
			    </div>
        </div>
        <span class="selected_tables">Selected tables: {{ selectedSequences }}</span>
        <button class="register_button buttons_additional" v-on:click="goToMenu()">Save</button>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default {
    name: 'Start',
    data() {
      return {
          selectedSequences: [],
          sequences: {
            
          }
      }
    },
    methods: {
   	  getSequence(){
        axios.get('http://localhost:8090/Sequence/findAll')
        .then(function (response) {
            this.sequences = response.data;
            console.log(this.sequences);
        }.bind(this))
        .catch((error)=>{
          this.$router.push('/menu'); 
        });
         
        
      },
      goToMenu(){
        this.$store.commit("setSequences", {
            selectedSequences: this.selectedSequences
          })
        this.$router.push('/menu');
      }
    },
    created: function(){
    	this.getSequence();
    }
  }
</script>
<style scoped lang="scss">

@import '@/styles/variables.scss';

h1, h2 {
    font-size: 50px;
    text-align: center;
    width: 100%;
    margin: 30px 0;
}

.background_login{
  background: url('../assets/banner.jpg');
  background-position: center;
  background-size: cover;
  display: flex;
  align-items: center;
}
.w100{
   height: 100vh;

  .login_bcg{
    position: absolute;
    top: 0;
    left: 0;
    min-height: 100vh;
    margin: 0 auto;
  }

  .header{
    margin-bottom: 70px;
  }


    .error{
      color: red;
      display: block;
    }

    .selected_tables{
    	display: block;
      width: 100%;
      margin: 30px 0;
    }
    .menu{
    	width: 100%;
      display: flex;
      align-items: center;
      justify-content: center;
  
    	input{
    		margin-bottom: 0!important;
    		margin-right: 15px!important;
        margin-left: 15px!important;
    		display: inline-block;
    	}
    	label{
    		padding: 0;
    		display: inline-block;
    	}
    }

   
 

    .register_button, .google_button{
      color: $basic_color;
      padding: 10px 15px;
      margin: 15px auto;
      display: table;
      min-width: 200px;
      position: relative;
      text-indent: 999;

      &:before{
        height: 100%;
        width: 0;
        position: absolute;
        content: "";
        background: rgba(0, 0, 0, 0.4);
        display: block;
        left: 0;
        top: 0;
      }

    }

    .register_button:hover, .google_button:hover{
      &:before{
        animation-name: showButton;
        animation-duration: 0.5s;
        animation-fill-mode: forwards;  
      }
    }

    .register_button{
      background-color: $basic_green;
      border: none;
      box-shadow: transparent;
    }

    .google_button{
      background-color: $basic_grey;
    }
 
}

  /*ANIMATIONS*/

@-webkit-keyframes showButton {
  from {width: 0}
  to {width: 100%}
}

</style>

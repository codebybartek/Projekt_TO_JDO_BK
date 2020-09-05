<template>
  <div class="w100 background_login navbar-offset-top">
    <div class="container">
      <div class="row">
        <section class="col-12 form_register">
          <h1>Menu: </h1>
          <nav class="menu">
          	<ul>
          		<li v-for="sequence in selectedSequences"><router-link :to="'./model/' + sequence.split('.')[sequence.split('.').length-1] ">{{sequence.split('.')[sequence.split('.').length-1]}}</router-link></li>
          	</ul>
          </nav>
        </section>
      </div>
    </div>
  </div>
</template>

<script>
  import axios from 'axios';
  export default {
    name: 'Menu',
    data() {
      return {
        selectedSequences: [],
        success: ''
      }
    },
    methods: {
    },
    created: function(){
      //this.$emit('toggleNavbar');
      this.selectedSequences = this.$store.getters.getSequences;
      console.log("sdfsfdsfds"+this.selectedSequences);
    }
  }
</script>

<style scoped lang="scss">

@import '@/styles/variables.scss';
h1{
  font-size: 2.5em;  
  margin-top: 15px;
  span{
    float: right;
    font-size: 0.7em;
    line-height: 2em;
    vertical-align: bottom;
  }
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

  .form_register{
    margin: 50px auto;

    .error{
      color: red;
      display: block;
    }

    input, select{
      width: 100%;
      max-width: 500px;
      display: block;
      margin: 0 auto;
      padding: 10px;
      border: 1px solid $basic_color;
      background: transparent;
      text-align: center;
      font-weight: 300;
      color: #fff;
      font-size: $basic;
      margin-bottom: 15px;
      outline: none;
    }

    select{
      option{
        color: $dark_grey!important;
      }
    }

    input:focus, input:focus, input:active, input:active{
      border-color: $basic_blue;
    }
    .button-primary{
      border: 1px solid $basic_color;
      background-color: transparent;
      padding: 10px 80px;
      margin-top: 20px;
      transition: 0.4s;
      outline: none;
      cursor: pointer;
      color: $basic_color;
    }
    .button-primary:focus, .button-primary:active, .button-primary:hover{
      border-color: $basic_green;
      color: $basic_green;
    }
  }

}
  ul {
    list-style-type: none;
    padding: 0;
  }
  li {
    display: inline-block;
    margin: 0 10px;
  }
  a {
    color: #42b983;
  }




</style>

import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
     sequences: [],
     record: null,
     keys: []
  },
  getters: {
      getSequences(state){
          return state.sequences;
      },
      getRecord(state){
          return state.record;
      },
      getKeys(state){
          return state.keys;
      }
  },
  mutations: {
    setSequences(state, payload){
        state.sequences = payload.selectedSequences;
    },
    setRecord(state, payload){
        state.record = payload.record;
    },
    setKeys(state, payload){
        state.keys = payload.keys;
    }
}
});
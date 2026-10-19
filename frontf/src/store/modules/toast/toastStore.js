
const state = {
  text: '',
  show: false,
  variant: 'info',
  timeOutId : null
};

const mutations = {
  showToast(state,{text,variant = 'info',duration=3000}) {
    state.show = true;  
    state.text = text;
    state.variant = variant;

    if (state.timeOutId) clearTimeout(state.timeOutId);
    state.timeOutId = setTimeout(() => {
      state.show = false;
      state.text = '';
    }, duration);
  },
  hideToast(state) {
    state.show = false;  
    state.text = '';
    if (state.timeOutId) clearTimeout(state.timeOutId);
    state.timeOutId = null;
  }
};

const getters = {
  toast: state => ({ text: state.text, show: state.show , variant : state.variant}) 
};

const actions = {
  triggerToast(_, { text, title = 'پیام', variant = 'info' }) {
    this.$bvToast.toast(text, {
      title,
      variant,
      solid: true,
      toaster: 'b-toaster-top-center',
      autoHideDelay: 3000
    });
  }
};

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions     
};

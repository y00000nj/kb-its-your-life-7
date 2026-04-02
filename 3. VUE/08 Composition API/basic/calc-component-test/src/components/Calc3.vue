<template>
  <div>
    <h2>calc3</h2>
    X: <input type="text" v-model.number="state.x" />
  </div>
</template>

<script>
import { reactive } from 'vue';

export default {
  name: 'Calc3',
  setup() {
    const state = reactive({ x: 10, y: 20, result: 30 });

    const calcAdd = () => {
      state.result = state.x + state.y;
    };
    return { state, calcAdd };
  },
};
</script>

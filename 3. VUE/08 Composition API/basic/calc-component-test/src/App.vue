<template>
  <div>
    <Calc1></Calc1>
    <Calc2></Calc2>
    <Calc3></Calc3>
  </div>
</template>

<script>
import Calc1 from './components/Calc1.vue';
import Calc2 from './components/Calc2.vue';
import Calc3 from './components/Calc3.vue';
export default {
  name: 'App',
  components: { Calc1, Calc2, Calc3 },
};
</script>

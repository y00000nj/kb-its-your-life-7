<template>
  <div>
    <h2>App 컴포넌트</h2>
    <hr />
    <ul>
      <CheckBoxItem
        v-for="idol in idols"
        :key="idol.id"
        :name="idol.name"
        :checked="idol.checked"></CheckBoxItem>
    </ul>
  </div>
</template>

<script>
import CheckBoxItem from './components/CheckBoxItem.vue';

export default {
  name: 'App',
  components: { CheckBoxItem }, //자식 컴포넌트 등록
  data() {
    return {
      idols: [
        { id: 1, name: 'BTS', checked: true },
        { id: 2, name: 'Black Pink', checked: false },
        { id: 3, name: 'EXO', checked: false },
        { id: 4, name: 'ITZY', checked: false },
      ],
    };
  },
};
</script>

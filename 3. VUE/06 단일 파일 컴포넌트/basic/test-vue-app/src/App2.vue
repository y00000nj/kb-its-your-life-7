<!-- 속성을 이용해 객체 전달하기 -->
<!-- 전달할 속성이 많은 경우 객체로 전달 -->

<template>
  <div>
    <h2>관심 있는 가수</h2>
    <hr />
    <ul>
      <CheckBoxItem2 v-for="idol in idols" :key="idol.id" :idol="idol"></CheckBoxItem2>
    </ul>
  </div>
</template>

<script>
import CheckBoxItem2 from './components/CheckBoxItem2.vue';
export default {
  name: 'App',
  components: { CheckBoxItem2 }, //자식 컴포넌트 등록
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

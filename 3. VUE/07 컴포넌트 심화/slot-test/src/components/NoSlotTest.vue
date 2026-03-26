<script>
import CheckBox1 from './CheckBox1.vue';

export default {
  name: 'NoSlotTest',
  components: { CheckBox1 },
  data() {
    return {
      items: [
        { id: 'V', checked: true, label: 'Vue' },
        { id: 'A', checked: false, label: 'Angular' },
        { id: 'R', checked: false, label: 'React' },
        { id: 'S', checked: false, label: 'Svelte' },
      ],
    };
  },
  methods: {
    CheckBoxChanged(e) {
      let item = this.items.find((item) => item.id === e.id);
      //'e.id'를 써서 누군지 찾고
      item.checked = e.checked;
      //'e.checked'를 써서 값을 바꿈
    },
  },
};
</script>

<template>
  <div>
    <h3>당신이 경험한 프론트 엔드 기술은?(첫번째:Slot 사용(x))</h3>
    <CheckBox1
      v-for="item in items"
      :key="item.id"
      :id="item.id"
      :label="item.label"
      :checked="item.checked"
      @checked-change="CheckBoxChanged" />
  </div>
</template>

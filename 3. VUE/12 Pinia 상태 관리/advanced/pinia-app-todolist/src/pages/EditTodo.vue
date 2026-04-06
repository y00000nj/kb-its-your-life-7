<template>
  <div class="row">
    <div class="col p-3">
      <h2>할일 수정</h2>
    </div>
  </div>
  <div class="row">
    <div class="col">
      <div class="form-group">
        <label htmlFor="todo">할일:</label>
        <input type="text" class="form-control" id="todo" v-model="todoItem.todo" />
      </div>
      <div class="form-group">
        <label htmlFor="desc">설명:</label>
        <textarea class="form-control" rows="3" id="desc" v-model="todoItem.desc"></textarea>
      </div>
      <div class="form-group">
        <label htmlFor="done">완료여부 : </label>&nbsp;
        <input type="checkbox" />
      </div>
      <div class="form-group">
        <button type="button" class="btn btn-primary m-1">수 정</button>
        <button type="button" class="btn btn-primary m-1">취 소</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { reactive } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import { useTodoListStore } from '@/stores/todoList.js';

const router = useRouter();
const currentRoute = useRoute();

const { todoList, updateTodo } = useTodoListStore();

//실제 todoList에 있는지 확인
const matchedTodoItem = todoList.value.find((item) => item.id === currentRoute.params.id);
if (!matchedTodoItem) {
  router.push('/todos');
}
const todoItem = reactive({ ...matchedTodoItem }); //여기서는 왜 reactive쓰는지 ,,

const updateTodoHandler = () => {
  let { todo } = todoItem;
  if (!todo || todo.trim() === '') {
    alert('할 일은 반드시 입력해야합니다.');
    return;
  }
  //그냥 일괄적으로ㅓ 넘기는 게 속편함 (스냅샷이라는 거야 아니라는 거야)
  // updateTodo({ ...todoItem });
  // router.push('/todos');
  updateTodo({ ...todoItem }, () => {
    router.push('/todos');
  });
};
</script>

import { reactive, computed } from 'vue';
import { defineStore } from 'pinia';
import axios from 'axios';

export const useTodoListStore = defineStore('todoList', () => {
  // 1. 상태 및 상수 정의 (스토어 내부)
  const BASEURL = '/api/todos'; // 이름을 하나로 통일!
  const state = reactive({
    todoList: [],
    isLoading: false, // isLoading 추가!
  });

  // 2. 할 일 목록 조회
  const fetchTodoList = async () => {
    state.isLoading = true; // 로딩 시작
    try {
      const response = await axios.get(BASEURL);
      if (response.status === 200) {
        // statue -> status 오타 수정
        state.todoList = response.data;
      }
    } catch (error) {
      alert('데이터 조회 실패: ' + error);
    } finally {
      state.isLoading = false; // 로딩 끝
    }
  };

  // 3. 할 일 추가 (원본 코드에 빠져있어서 추가했습니다)
  const addTodo = async ({ todo, desc }, successCallback) => {
    try {
      const payload = { todo, desc, done: false };
      const response = await axios.post(BASEURL, payload);
      if (response.status === 201) {
        state.todoList.push(response.data);
        successCallback(); // 성공 시 페이지 이동 등 실행
      }
    } catch (error) {
      alert('추가 실패: ' + error);
    }
  };

  // 4. 할 일 수정
  const updateTodo = async ({ id, todo, desc, done }, successCallback) => {
    try {
      const payload = { id, todo, desc, done };
      const response = await axios.put(`${BASEURL}/${id}`, payload);
      if (response.status === 200) {
        let index = state.todoList.findIndex((item) => item.id === id);
        if (index !== -1) {
          state.todoList[index] = payload; // 데이터를 payload로 교체!
        }
        successCallback(); // 콜백 함수 실행
      }
    } catch (error) {
      alert('변경 실패: ' + error);
    }
  };

  // 5. 할 일 삭제
  const deleteTodo = async (id) => {
    try {
      const response = await axios.delete(`${BASEURL}/${id}`);
      if (response.status === 200) {
        let index = state.todoList.findIndex((item) => item.id === id);
        if (index !== -1) {
          state.todoList.splice(index, 1);
        }
      }
    } catch (error) {
      alert('삭제 실패: ' + error);
    }
  };

  // 6. 완료 여부 토글
  const toggleDone = async (id) => {
    try {
      let todo = state.todoList.find((item) => item.id === id);
      if (!todo) return;

      let payload = { ...todo, done: !todo.done };
      const response = await axios.put(`${BASEURL}/${id}`, payload);
      if (response.status === 200) {
        todo.done = payload.done; // 참조 타입의 특징 활용 (화면 자동 갱신)
      }
    } catch (error) {
      alert('토글 실패: ' + error);
    }
  };

  // 7. 계산된 속성 (Getters)
  const todoList = computed(() => state.todoList);
  const isLoading = computed(() => state.isLoading);
  const doneCount = computed(() => {
    return state.todoList.filter((item) => item.done).length;
  });

  // 8. 반드시 모든 변수/함수를 객체에 담아 return! (정의 함수 내부에서)
  return {
    todoList,
    isLoading,
    doneCount,
    fetchTodoList,
    addTodo,
    deleteTodo,
    updateTodo,
    toggleDone, // toggledDone -> toggleDone 이름 맞춤
  };
}); // defineStore 괄호는 여기서 닫힙니다!

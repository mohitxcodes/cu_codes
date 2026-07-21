const taskInput = document.getElementById("taskInput");
const prioritySelect = document.getElementById("prioritySelect");
const addBtn = document.getElementById("addBtn");
const taskList = document.getElementById("taskList");
const filterBtns = document.querySelectorAll(".filter-btn");

let tasks = [];
let currentFilter = "all";

addBtn.addEventListener("click", function () {
  const name = taskInput.value.trim();
  if (name === "") {
    alert("Please enter a task name");
    return;
  }

  tasks.push({
    id: Date.now(),
    name: name,
    priority: prioritySelect.value,
    completed: false,
  });

  taskInput.value = "";
  renderTasks();
});

filterBtns.forEach(function (btn) {
  btn.addEventListener("click", function () {
    filterBtns.forEach(function (b) {
      b.classList.remove("active");
    });
    btn.classList.add("active");
    currentFilter = btn.dataset.filter;
    renderTasks();
  });
});

function renderTasks() {
  taskList.innerHTML = "";

  let filtered = tasks;
  if (currentFilter === "completed") {
    filtered = tasks.filter(function (t) {
      return t.completed;
    });
  }

  filtered.forEach(function (task) {
    const li = document.createElement("li");
    if (task.completed) li.classList.add("completed");

    li.innerHTML =
      '<div class="task-info">' +
      '<span class="task-name">' +
      task.name +
      "</span>" +
      '<span class="priority-badge ' +
      task.priority +
      '">' +
      task.priority +
      "</span>" +
      "</div>" +
      '<div class="task-actions">' +
      '<button class="complete-btn" onclick="toggleComplete(' +
      task.id +
      ')">' +
      (task.completed ? "Undo" : "Complete") +
      "</button>" +
      '<button class="delete-btn" onclick="deleteTask(' +
      task.id +
      ')">Delete</button>' +
      "</div>";

    taskList.appendChild(li);
  });
}

function toggleComplete(id) {
  tasks.forEach(function (t) {
    if (t.id === id) t.completed = !t.completed;
  });
  renderTasks();
}

function deleteTask(id) {
  tasks = tasks.filter(function (t) {
    return t.id !== id;
  });
  renderTasks();
}

let input = document.querySelector("#todo-input");
let btn = document.querySelector("#btn");
let list = document.querySelector("#todo-list");
let update = document.querySelector("#update");

btn.addEventListener("click", function () {
  let todo = input.value;
  let dlt = document.createElement("button");
  dlt.innerText = "Delete";
  let edit = document.createElement("button");
  edit.innerText = "Edit";
  let span = document.createElement("span");

  if (todo === "") {
    alert("Please enter a todo");
    return;
  }

  let li = document.createElement("li");
  li.appendChild(span);
  span.textContent = todo;
  list.appendChild(li);
  li.appendChild(dlt);
  li.appendChild(edit);

  input.value = "";

  dlt.addEventListener("click", function () {
    li.remove();
    dlt.remove();
  });

  edit.addEventListener("click", function () {
    input.value = span.innerText;
    update.addEventListener("click", function () {
      span.innerText = input.value;
      list.appendChild(li);
      li.appendChild(dlt);
      li.appendChild(edit);
      input.value = "";
    });
  });
});

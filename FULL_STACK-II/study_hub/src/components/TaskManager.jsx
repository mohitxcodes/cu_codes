import { useReducer, useState } from 'react';
import { Navigate } from 'react-router-dom';
import { useUser } from '../StudentContext';

const initialTasks = [
  { id: 1, title: "Finish DBMS assignment", completed: false },
  { id: 2, title: "Revise React hooks", completed: false },
  { id: 3, title: "Submit lab report", completed: true },
];



function taskReducer(state, action) {
  switch (action.type) {
    case 'SET_TASKS':
      return action.payload;
    case 'ADD_TASK':
      return [...state, { id: Date.now(), title: action.payload, completed: false }];
    case 'TOGGLE_TASK':
      return state.map(task => 
        task.id === action.payload ? { ...task, completed: !task.completed } : task
      );
    case 'DELETE_TASK':
      return state.filter(task => task.id !== action.payload);
    default:
      return state;
  }
}

export default function TaskManager() {
  const { isLoggedIn } = useUser();
  const [tasks, dispatch] = useReducer(taskReducer, initialTasks);
  const [newTask, setNewTask] = useState('');

  if (!isLoggedIn) {
    return <Navigate to="/login" replace />;
  }

  const handleAddTask = () => {
    if (newTask.trim()) {
      dispatch({ type: 'ADD_TASK', payload: newTask });
      setNewTask('');
    }
  };

  return (
    <div>
      <h2>MY TASKS</h2>
      <div>
        <label>New task: </label>
        <input 
          type="text" 
          value={newTask} 
          onChange={(e) => setNewTask(e.target.value)} 
        />
        <button onClick={handleAddTask}>Add Task</button>
      </div>
      <br />
      <div>
        {tasks.map(task => (
          <div key={task.id} style={{ marginBottom: '8px' }}>
            <label>
              <input 
                type="checkbox" 
                checked={task.completed} 
                onChange={() => dispatch({ type: 'TOGGLE_TASK', payload: task.id })}
              />
              {task.title}
            </label>
            {" "}
            <button onClick={() => dispatch({ type: 'DELETE_TASK', payload: task.id })}>
              Delete
            </button>
          </div>
        ))}
      </div>
    </div>
  );
}

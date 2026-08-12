import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import heroImg from './assets/hero.png'
import { Link, Navigate, Route, Routes, useLocation, useNavigate, useParams } from 'react-router-dom'
import Home from './components/Home'
import Login from './components/Login'

function App() {
  const [count, setCount] = useState(0)

  const naviagte = useNavigate();
  const parm = useParams();
  const loc = useLocation();
  console.log(loc);

  const [isActive , setIsActive] = useState(true);


  return (
<>
      <div>This is the App JSX Page</div>
      <Link to={"/home"}>Home</Link>
      <br></br>
      <Link to={"/login"}>Login</Link>
      <br />
      <button onClick={() => naviagte(-2)}>Back</button>
      <br />

      {
        isActive && (<Navigate to={"/login"}/>)
      }

    <Routes>
       <Route path='/home' element={<Home/>}/>
       <Route path='/login' element={<Login/>}/>
    </Routes>
</>
  )
}

export default App

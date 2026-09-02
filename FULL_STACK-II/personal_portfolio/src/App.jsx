import { useState } from 'react'
import heroImg from './assets/hero.png'
import reactLogo from './assets/react.svg'
import viteLogo from './assets/vite.svg'
import './App.css'
import { Route, Routes } from 'react-router-dom'
import HomePage from './components/HomePage'
import DashBoard from './components/DashBoard'
import Profile from './components/Profile'
import Settings from './components/Settings'
import Navbar from './layout/Navbar'
import About from '../pages/About'
import Contact from '../pages/Contact'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Navbar/>
      <Routes>
          <Route path='/' element={<HomePage/> } />
          <Route path='/about' element={<About/> } />
          <Route path='/contact' element={<Contact/> } />
          <Route path='/dashboard' element={ <DashBoard/> } >
            <Route path='profile' element={ <Profile/>} />
            <Route path='settings' element={ <Settings/>} />
          </Route>
      </Routes>
    </>
  )
}

export default App

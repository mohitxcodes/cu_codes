import React from 'react'
import { useNavigate } from 'react-router-dom'

function Navbar() {
  const navigate = useNavigate()

  return (
    <nav style={{
      display: 'flex',
      justifyContent: 'space-between',
      alignItems: 'center',
      padding: '0px 30px',
      border: '1px solid black'
    }}>
      
      <h2>Personal Portfolio</h2>

      <div style={{ display: 'flex', gap: '25px' }}>
        <button onClick={() => navigate('/')}>Home</button>
        <button onClick={() => navigate('/about')}>About</button>
        <button onClick={() => navigate('/contact')}>Contact</button>
        <button onClick={() => navigate('/dashboard')}>Dashboard</button>
      </div>

    </nav>
  )
}

export default Navbar
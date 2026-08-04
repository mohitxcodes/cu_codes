import { useState } from 'react'
import ThemeContext from './hooks/ThemeContext'
import Child1 from './components/Child1'
import Child2 from './components/Child2'

function App() {
  const [theme, setTheme] = useState('light');

  return (

    <ThemeContext.Provider  value={{theme , setTheme}}>
      <div>
      <h1>Theme Context App</h1>
      <Child1/>
      <Child2/>
</div>
    </ThemeContext.Provider>
  )
}

export default App;

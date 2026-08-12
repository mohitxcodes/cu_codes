import { useState } from 'react'
import Sum from './components/Sum'

function App() {
  const [count, setCount] = useState(0)


  return (

    <div>
      <Sum/>
    </div>
    
  )
}

export default App

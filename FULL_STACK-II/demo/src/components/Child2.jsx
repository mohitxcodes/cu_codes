import React, { useContext } from 'react'
import ThemeContext from '../hooks/ThemeContext'

function Child2() {

    const {theme, setTheme} = useContext(ThemeContext);

    const btnHandle = () => {
        if(theme == 'light'){
            setTheme('dark');
        }else{
            setTheme('light');
        }
    }

  return (
    <div style={theme == 'light' ? {background : ''} : {background : 'black'}}>
        <h2 style={theme == 'dark' ? {color : 'white'} : {}}>Theme is : {theme}</h2>
        <button onClick={btnHandle}>Change Theme</button>
    </div>
  )
}

export default Child2
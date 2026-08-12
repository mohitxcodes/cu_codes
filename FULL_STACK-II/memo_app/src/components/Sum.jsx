import React from 'react'

const Sum = React.memo(() => {

    const totalSum = () => {
        let sum = 0;
        for(let i = 0; i < 1000;i++){
            sum += i;
        }
        return sum;
    }
    const finalSum = totalSum();

  return (
    <div>Total Sum : {finalSum}</div>
  )
})

export default Sum;
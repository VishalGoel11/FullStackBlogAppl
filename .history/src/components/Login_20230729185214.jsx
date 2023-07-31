import React from 'react'

const Login = () => {
  return (
    <div className="bg-[url('assets\heroBg.jpg')] bg-cover md:h-screen flex">
      <form className='pt-96 '>
        <div className='bg-white text-black p-23'>
        <div className='flex flex-col'>
        <input type="text" />
        <input type="text" />
        </div>
        <p>Forgot Password</p>
        <button>Login</button>
        </div>
      </form>


    </div>
  )
}

export default Login
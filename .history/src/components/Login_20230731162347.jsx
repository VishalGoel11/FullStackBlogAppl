import React from 'react'

const Login = () => {
  return (
    <div className="bg-[url('assets\heroBg.jpg')] bg-cover md:h-screen flex">
      <form className='p-56 '>
        <div className='bg-white text-black p-16 '>
        <div className='flex flex-col gap-8'>
        <input type="text" className='bg-black text-white'/>
        <input type="text" className='bg-black text-white'/>
        </div>
        <p className='text-sm text-gray-400 mt-10'>Forgot Password</p>
        <button>Login</button>
        </div>
      </form>


    </div>
  )
}

export default Login
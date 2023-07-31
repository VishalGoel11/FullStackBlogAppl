import React from 'react'

const Login = () => {
  return (
    <div className="bg-[url('assets\heroBg.jpg')] bg-cover md:h-screen pt-10">
      <form className='bg-white'>
        <div>
        <input type="text" />
        <input type="text" />
        <p>Forgot Password</p>
        <button>Login</button>
        </div>
      </form>


    </div>
  )
}

export default Login
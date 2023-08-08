import React from 'react'

const Signup = () => {
  return (
    <div className="bg-[url('assets\heroBg.jpg')] bg-cover md:h-screen flex">
      <form className='p-56 '>
        <div className='bg-white text-black p-1 '>
        <div className='flex flex-col gap-8'>
        <input type="text" className='bg-black text-white text-sm h-7 px-2' placeholder='Email'/>
        <input type="text" className='bg-black text-white  text-sm h-7 px-2' placeholder='Password'/>
        <input type="text" className='bg-black text-white text-sm h-7 px-2' placeholder='Email'/>
        <input type="text" className='bg-black text-white  text-sm h-7 px-2' placeholder='Password'/>
        </div>
        <button className='border-2 px-5 mt-5 border-black'>Sign Up</button>
        </div>
      </form>


    </div>
  )
}

export default Signup
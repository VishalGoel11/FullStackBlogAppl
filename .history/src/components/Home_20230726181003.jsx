import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLock, faUser } from '@fortawesome/free-solid-svg-icons'
import Logo from '../assets/logo.png'


const Home = () => {
  return (
    <div className ="bg-[url('assets\heroBg.jpg')] bg-cover md:h-screen mt0">
        <div className='flex flex-col md:flex-row justify-between p-8 md:mx-8 place-items-center'>
            <div className='w-52'>
              <img src= {Logo} alt=""  />
            </div>
            <div className='cursor-pointer list-none p-2 gap-x-2  md:gap-10' >
             <a href="www.google.com" target='_blank'><li className='border-2 px-2 py-1'>Connect</li></a>
            </div>
        </div>
        <div className='md:flex md:justify-around'>
          <div className='text-center mt-5 mx-10 md:w-1/2 md:text-left md:my-24'>
            <h1 className='text-4xl md:text-5xl font-bold  '>Ink & Imagination:<br/> Where Creativity Knows No Bounds</h1>
            <p className='mt-5 text-gray-100'>Discover insightful articles and stay informed on various topics. Engage, learn, and grow with us!</p>
          </div>
          {/* <div className='bg-white md:px-10 m-10 text-black rounded-md py-10'>
            <div className='text-center '>
              <h2  className='text-xl font-bold md:text-2xl'>Welcome</h2>
              <p>Don't have an account?<br/><span className='underline cursor-pointer'>Create one!</span></p>
            </div>
              <div className='grid justify-center gap-y-5 md:gap-y-8 py-10'>
                <div className='flex gap-2'>
                  <FontAwesomeIcon icon={faUser} />
                  <input type="text" className='border-b-2 border-black w-4/5 md:w-full' placeholder='Username' />
                </div>
                <div className='flex gap-2'>
                  <FontAwesomeIcon icon={faLock} />
                  <input type="text" className='border-b-2 border-black w-4/5 md:w-full' placeholder='Password'/>
                </div>
              </div>
                <div className='text-center bg-black text-white px-10 py-2 rounded-md mx-20'>
                  <button  className='font-bold'>login</button>
                </div>
          </div> */}
        </div>
    </div>
  )
}

export default Home
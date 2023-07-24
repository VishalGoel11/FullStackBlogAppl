import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faLock, faUser } from '@fortawesome/free-solid-svg-icons'
import Logo from '../../assets/logo.png'


const Home = () => {
  const nav_menu = [
    {name: 'Home',
    url: '/'},
    {name: 'Contact',
     url: '/contact'},
  ]
  return (
    <div className ="bg-[url('assets\heroBg.jpg')] bg-cover h-screen">
        <div className='flex justify-between p-8'>
            <div className='w-52'>
              <img src= {Logo} alt=""  />
            </div>
            <div className='flex justify-between list-none pt-2 gap-x-2  md:gap-10' >
             {nav_menu.map(menu =>(
              <li url= {menu.url}>{menu.name}</li>
             ))}
            </div>
        </div>
        <div className='md:flex md:justify-around'>
          <div className='text-center mt-10 mx-10 md:w-1/2 md:text-left md:mt-24'>
            <h1 className='text-4xl md:text-5xl font-bold  '>Ink & Imagination:<br/> Where Creativity Knows No Bounds</h1>
            <p className='mt-5'>Discover insightful articles and stay informed on various topics. Engage, learn, and grow with us!</p>
          </div>
          <div className='bg-white md:px-20 m-10 text-black rounded-md py-10'>
            <div className='text-center '>
              <h2  className='text-xl font-bold md:text-2xl'>Welcome</h2>
              <p>Don't have an account?<br/><span className='underline cursor-pointer'>Create one!</span></p>
              {/* <div className='bg-black w-20 h-2 '> .</div> */}
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
          </div>
        </div>
    </div>
  )
}

export default Home
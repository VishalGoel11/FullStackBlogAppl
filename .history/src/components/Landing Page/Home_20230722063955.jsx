import React from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faCoffee, faUser } from '@fortawesome/free-solid-svg-icons'


const Home = () => {
  const nav_menu = [
    {name: 'Home',
    url: '/'},
    {name: 'Contact',
     url: '/contact'},
  ]
  return (
    <div className ="bg-[url('assets\heroBg.jpg')] h-sreen pb-44 bg-cover ">
        <div className='flex justify-between p-8'>
            <div className='w-36'>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRs_PVVYnGyr7--KmAUEtr-DOxh-GUhG7VOQg&usqp=CAU" alt=""  />
            </div>
            <div className='flex justify-between'>
             {nav_menu.map(menu =>(
              <li url= {menu.url}>{menu.name}</li>
             ))}
            </div>
        </div>
        <div>
          <div className='text-center mt-20'>
            <h1 className='text-3xl font-bold'>Lorem ipsum dolor sit amet.</h1>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Harum excepturi alias qui magnam nisi libero?</p>
          </div>
          <div className='bg-white m-10 text-black rounded-md py-5'>
            <div className='text-center '>
              <h2 >Welcome</h2>
              <p>Lorem ipsum dolor sit amet.</p>
              {/* <div className='bg-black w-20 h-2 '> .</div> */}
            </div>
              <div className='grid justify-center gap-y-5 py-5'>
                <div className='grid gap-x-2'>
                  <FontAwesomeIcon icon={faUser} />
                  <input type="text" className='bg-black rounded-md' />
                </div>
                <div>
                  <FontAwesomeIcon icon={faUser} />
                  <input type="text" className='bg-black' />
                </div>
                <div className='justify-self-center'>
                  <button>login</button>
                </div>
              </div>
          </div>
        </div>
    </div>
  )
}

export default Home
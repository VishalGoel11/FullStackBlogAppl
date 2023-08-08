import React from 'react'


const Home = () => {
  const nav_menu = [
    {name: 'Home',
    url: '/'},
    {name: 'Contact',
     url: '/contact'},
  ]
  return (
    <div className ="bg-[url('assets\heroBg.jpg')] w-sreen">
        <div className='flex justify-between'>
            <div>
            </div>
            <div className='flex'>
             {nav_menu.map(menu =>(
              <li url= {menu.url}>{menu.name}</li>
             ))}


            </div>
        </div>
    </div>
  )
}

export default Home
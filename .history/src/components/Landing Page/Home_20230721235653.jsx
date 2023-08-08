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
          <div>
            <h1>Lorem ipsum dolor sit amet.</h1>
            <p>Lorem ipsum dolor sit, amet consectetur adipisicing elit. Harum excepturi alias qui magnam nisi libero?</p>
          </div>
        </div>
    </div>
  )
}

export default Home
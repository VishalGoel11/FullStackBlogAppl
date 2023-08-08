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
        <div>
            <div>
              <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRs_PVVYnGyr7--KmAUEtr-DOxh-GUhG7VOQg&usqp=CAU" alt="" className='w-48' />
            </div>
            <div>
             {nav_menu.map(menu)=>{
              <li url={menu.url}>{menu.name}</li>

             }}


            </div>
        </div>
    </div>
  )
}

export default Home
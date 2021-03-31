import React from 'react';
import './Home.css'
import Home_image from '../../image/Home_page1.jpg'

const Home=() =>(
  <React.Fragment>
    
    <div>
      <div className="row">
        <div className="col-sm">
          <div>
            <img className="" src={Home_image} class="card-img-top" alt="..." height="1000px" width="1100px" />
          </div>
        </div>
      </div>
    </div>
  </React.Fragment>
)

export default Home;
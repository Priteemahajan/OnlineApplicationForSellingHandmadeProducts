import React from 'react';
import './Dashboard.css';
import Maharashtra from '../../image/Maharashtra_image.jpg';
import Kashmir from '../../image/Kashmir_image.jpg';
import Rajasthan from '../../image/Rajasthan_image.jpg';
import Tamilnadu from '../../image/Tamilnadu_image.jpg';


function Dashboard(){
  return(
    <React.Fragment>
      <div className="container">
        <div className="row">
          <div className="col-sm-3">
            <div class="card">
              <img src={Maharashtra} class="card-img-top" alt="..." height="160px" />
              <div class="card-body">
                <h5 class="card-title">Maharashtra</h5>
                <p class="card-text">There are some very famous crafts of Maharashtra such as sawantwadi crafts, bidri works, leather works, weaving, Mashru and Himru, Paintings and so on. These crafts portray the rich cultural heritage of Maharashtra and showcase the unique blend of different traditions..</p>
              </div>
            </div>
          </div>
          <div className="col-sm-3">
          <div class="card">
              <img src={Kashmir} class="card-img-top" alt="..." height="160px" />
              <div class="card-body">
                <h5 class="card-title">Kashmir</h5>
                <p class="card-text">Jammu and Kashmir have a rich heritage of art and craft. ... Kashmir's most famous handcrafted specialties include silk and Wool Carpets, Papier-mache Products, Pashminas, Silverware, Copperware, Embroidered shawls, and Wood. The city is considered as a treasure of art and crafts..</p>
              </div>
            </div>
          </div>
          <div className="col-sm-3">
          <div class="card">
              <img src={Rajasthan} class="card-img-top" alt="..." height="160px" />
              <div class="card-body">
                <h5 class="card-title">Rajasthan</h5>
                <p class="card-text">When it comes to sheer variety, beauty and brilliance, the handicrafts of Rajasthan are hard to beat. From elegant Meenakari work to beautiful block prints; from chunky silver jewellery to camel leather jootis, this state’s craftsmen (and women!) produce a mind-boggling array of goods that make for stunning souvenirs..</p>
              </div>
            </div>
          </div>
          <div className="col-sm-3">
          <div class="card">
              <img src={Tamilnadu} class="card-img-top" alt="..." height="160px" />
              <div class="card-body">
                <h5 class="card-title">Tamilnadu</h5>
                <p class="card-text">Tamil Nadu crafts are very creative and attractive. Here the people bent their minds with great creativity to create the crafts. The crafts are made with dexterity and add value. Here the main crafts are stone craft, pottery, papier, metalware, wood craft and some other. Tamil Nadu artists prepare their crafts using their local sources..</p>
              </div>
            </div>
          </div>
        </div>
        </div>
    </React.Fragment>
  );
}

export default Dashboard;
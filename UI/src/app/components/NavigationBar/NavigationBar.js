import React from 'react';
import './NavigationBar.css';
import { Link, IndexLink } from 'react-router';

const NavBar = (props) => {
    let navBarSection =
        <section id="navBar-section">
            <nav className="navbar navbar-inverse">
                <div className="container-fluid">
                    <div className="navbar-header" id="navBarHeading">
                        <span>DEUTSCHE BANK</span>
                    </div>
                    <ul className="nav navbar-nav">
                        <li><IndexLink to="/userHome" activeClassName="active" >Apply Education Loan</IndexLink></li>
                        <li>
                            <Link to="/loanStatus"
                                activeClassName="active">
                               Loan Disbursement</Link>
                        </li>
                    </ul>
                    <ul className="nav navbar-nav navbar-right">
                        <li><Link to="#">
                            <span className="glyphicon glyphicon-log-out" />
                            <span> Logout</span>
                        </Link></li>
                    </ul>
                </div>
            </nav>
        </section>;

    return navBarSection;
  };

export default NavBar;
import React from 'react';
import './AdminNavigationBar.css';
import { Link, IndexLink } from 'react-router';

const AdminNavBar = (props) => {
    let navBarSection =
        <section id="navBar-section">
            <nav className="navbar navbar-inverse">
                <div className="container-fluid">
                    <div className="navbar-header" id="navBarHeading">
                        <span>WELCOME ADMIN</span>
                    </div>
                    <ul className="nav navbar-nav">
                        <li><IndexLink to="/adminHome" activeClassName="active" >User Approvals</IndexLink></li>
                        <li>
                            <Link to="/loanApprovals"
                                activeClassName="active">
                              Loan Approvals</Link>
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

export default AdminNavBar;
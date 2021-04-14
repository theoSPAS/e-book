import './App.css';
import React,{Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom';
import Authors from '../Authors/authors';
import Header from '../Header/header';
import Countries from '../Countries/countries';
import Books from '../Books/BookList/books';
import Categories from '../Categories/categories';
import BookAdd from '../Books/BookAdd/bookAdd';
import BookEdit from '../Books/BookEdit/bookEdit';
import EShopService from "../../repository/eShopRepository";

class App extends Component{

    constructor(props) {
        super(props);
        this.state = {
            authors: [],
            countries: [],
            books: [],
            categories : [],
            selectedBook : {}
        }
    }


    render() {
     return (
       <Router>
          <Header />
           <main>
             <div className="container">
                 <Route path={"/authors"} exact render={() => <Authors authors={this.state.authors}/>}/>
                 <Route path={"/countries"} exact render={() => <Countries countries={this.state.countries}/>}/>
                 <Route exact path={"/categories"} exact render={() => <Categories categories={this.state.categories}/>}/>
                 <Route path={"/books/add"} exact render={() => <BookAdd authors={this.state.authors} categories={this.state.categories}
                                 onAddBook={this.addBook}/>}/>
                  <Route path={"/books/edit/:id"} exact render={() => <BookEdit authors={this.state.authors} categories={this.state.categories}
                                 onEditBook={this.editBook} book={this.state.selectedBook}/>}/>
                 <Route path={["/books","/"]} exact render={() => <Books books={this.state.books}
                        onDelete={this.deleteBook}
                        onEdit={this.getBook}
                        onMark={this.markBook}/>}/>
                 <Route to={"/books"} />
             </div>
           </main>
       </Router>
      );
  }

    loadAuthors = () => {
        EShopService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors : data.data
                })
            });
    }

   loadCountries = () => {
        EShopService.fetchCountries()
            .then((data) => {
                this.setState({
                    countries : data.data
                })
            });
   }

   loadCategories = () => {
      EShopService.fetchCategories()
          .then((data) => {
              this.setState({
                  categories : data.data
              })
          });
   }

   loadBooks = () => {
        EShopService.fetchBooks()
            .then((data) => {
                this.setState({
                    books : data.data
                })
            });
   }

   deleteBook = (id) => {
        EShopService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    addBook = (name, category, author, availableCopies) => {
        EShopService.addBook(name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        EShopService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook : data.data
                });
            })
    }

    editBook = (id,name, category, author, availableCopies) => {
        EShopService.editBook(id,name, category, author, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    markBook = (id) => {
        EShopService.markBook(id)
            .then(() => {
                this.loadBooks();
            });
    }
  componentDidMount() {
      this.loadAuthors();
      this.loadCountries();
      this.loadBooks();
      this.loadCategories();
  }


}

export default App;

import axios from '../custom-axios/axios';

const EShopService = {
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchBooks:() => {
        return axios.get("/books");
    },
    fetchCategories : () => {
       return axios.get("/categories");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },
    addBook : (name, category, author, availableCopies) => {
        axios.post("/books/add",{
            'name' : name,
            'category' : category,
            'author' : author,
            'availableCopies' : availableCopies
        })
    },
    editBook : (id,name, category, author, availableCopies) => {
        axios.put(`/books/edit/${id}`,{
            'name' : name,
            'category' : category,
            'author' : author,
            'availableCopies' : availableCopies
        })
    },
    getBook : (id) => {
        return axios.get(`/books/${id}`);
    },
    markBook : (id) => {
        return axios.put(`/books/taken/${id}`);
    }
}
export default EShopService;
import React from 'react';

const categories = (props) => {
    return(
        <div className={"container"}>
            <div class={"row"}>
                <table className={"table"}>
                   <thead>
                     <tr>
                         <th scope={"col"}>All Categories:</th>
                     </tr>
                   </thead>
                    <tbody>
                    {props.categories.map((term) => {
                        return(
                            <tr>
                                <td>{term}</td>
                            </tr>
                        )
                    })}
                    </tbody>
                </table>
            </div>
        </div>
    )
}

export default categories;

<#include "layout.ftlh">

<@layout title="Error">
    <div class="error-page">
        <div class="error-code">${errorCode!500}</div>
        <h1>${errorTitle!"Something went wrong"}</h1>
        <p>${errorMessage!"An unexpected error occurred. Please try again."}</p>
        <a href="/" class="btn-primary">Go Home</a>
    </div>
</@layout>
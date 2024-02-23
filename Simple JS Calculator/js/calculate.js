//Author: Graeme Jeffreys

//Date: 2024-02-15
//Version: 1.0.0
//Description: calculate.js performs 
//  the calculations and updates 
//  the result box respectively

// Variables used for the JS file
var input = ''; // Creates an empty variable 'input'
var total;
var result = document.getElementById('result'); // creates a result var linked to the result variable


/**
 * DOM to initialize when the page has fully loaded
 */
document.addEventListener('DOMContentLoaded', function () {
    input = ''; // Initialize input to an empty string
});

/**
 * This function takes the value of the button element clicked, and appends it onto the input
 * @param {*} value 
 */
function appendInput (value) {
    if(value == '*' || value == '-' || value == '+' || value == '/' || value == '%' || value == '(' || value == ')') {
        input += ' ' + value + ' ';
    } else {
        input += value;
    }
    updateDisplay(input); // use the update display function to update the calculator screen
}

/**
 * Clears the input/output line when the clear button is clicked
 */
function clearInput() {
    input = '';
    updateDisplay(input);
}

/**
 * This updates the input/output line when a button is clicked
 * @param {*} input 
 */
function updateDisplay(input) {
    if (result) {
        result.value = input;
    }
}

/**
 * Calculates the total by using the eval function to evaluate the string value determined 
 * in the input/output line
 */
function calculateResult() {

    input = input.toString();

    try { // Use try catch to ensure proper error handling while evaluating the expression
        if (input.trim() !== '') {
            total = eval(input);
            updateDisplay(total);
        } else {
            showError('Expression is empty'); // Shows error message if empty
        }
    } catch (error) {
        showError('Invalid expression'); // Displays invlaid error when try catch catches an error
    }
}

/**
 * Displays error message when there is an error or invalid expression to be evaluated.
 * @param {*} message 
 */
function showError(message) {
    alert(message);
    clearInput();
}
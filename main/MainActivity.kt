package com.example.sudoku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.sudoku.databinding.ActivityMainBinding
import org.w3c.dom.Text
import kotlin.random.Random
import kotlin.collections.*


class MainActivity : AppCompatActivity() {
    private lateinit var bindingClass : ActivityMainBinding



    //private var prevButton: Button? = null

    private var pressedButtonRow: Int = 0
    private var pressedButtonColumn: Int = 0
    private var pressedButtonId: Int = 0
    private var hintsRemaining : Int = 3

    private lateinit var bottonButtonOne: Button
    private lateinit var bottonButtonTwo: Button
    private lateinit var bottonButtonThree: Button
    private lateinit var bottonButtonFour: Button
    private lateinit var bottonButtonFive: Button
    private lateinit var bottonButtonSix: Button
    private lateinit var bottonButtonSeven: Button
    private lateinit var bottonButtonEight: Button
    private lateinit var bottonButtonNine: Button
    private lateinit var bottonFinish: Button
    private lateinit var bottonClear: Button
    private lateinit var buttonHint: Button


    private var difficultyLevel: Int = 0

    override fun onCreate(s: Bundle?) {
        super.onCreate(s)

        val alertBuilder = AlertDialog.Builder(this)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)

        setContentView(bindingClass.root)

        val gridLayoutPlayfield = findViewById<GridLayout>(R.id.gridLayoutPlayfield)

        //Generating sudoku grid
        val grid = generateSudokuGrid()
        var outputArray: Array<IntArray>

        difficultyLevel = intent.getIntExtra("difficulty", 0)
        do{
            outputArray = removeRandomNumbers(grid, difficultyLevel)
        } while (countSolutions(outputArray) > 1)

        val solutionsCount = countSolutions(outputArray)
        println("Solutions: $solutionsCount")


        //Generating list of buttons'numbers to remove
        //val positionsToRemove = generateRandomPositionsToRemove(49)


        val numRows = gridLayoutPlayfield.rowCount
        val numCols = gridLayoutPlayfield.columnCount

        val unpressedButtonBackgroundResId = R.drawable.greyborder
        val pressedButtonBackgroundResId = R.drawable.blackborder
        //val thickLineRight = R.drawable.thick_line

        var previousButton: Button? = null
        var previousRow: Int? = null // Row index of the previously pressed button
        var previousCol: Int? = null // Column index of the previously pressed button

        val buttonSizeDp = 80
        var buttonIdCounter = 1


        for (row in 0 until numRows) {
            for (col in 0 until numCols) {
                val button = Button(this)
                button.id = buttonIdCounter
                buttonIdCounter++

                button.textSize = 16F
                button.text = "0"

                button.setBackgroundResource(unpressedButtonBackgroundResId)

                val rowSpec = GridLayout.spec(row)
                val colSpec = GridLayout.spec(col)
                val layoutParams = GridLayout.LayoutParams(rowSpec, colSpec)
                layoutParams.width = buttonSizeDp
                layoutParams.height = buttonSizeDp

                button.layoutParams = layoutParams
                button.setOnClickListener {
                    previousButton?.setBackgroundResource(unpressedButtonBackgroundResId)
                    button.setBackgroundResource(pressedButtonBackgroundResId)

                    previousRow?.let {
                        for (i in 0 until numCols) {
                            val rowButton = gridLayoutPlayfield.getChildAt(it * numCols + i) as Button
                            rowButton.setBackgroundResource(unpressedButtonBackgroundResId)
                        }
                    }
                    previousCol?.let {
                        for (j in 0 until numRows) {
                            val colButton = gridLayoutPlayfield.getChildAt(j * numCols + it) as Button
                            colButton.setBackgroundResource(unpressedButtonBackgroundResId)
                        }
                    }

                    for (i in 0 until numRows) {
                        val rowButton = gridLayoutPlayfield.getChildAt(i * numCols + col) as Button
                        rowButton.setBackgroundResource(pressedButtonBackgroundResId)
                    }
                    for (j in 0 until numCols) {
                        val colButton = gridLayoutPlayfield.getChildAt(row * numCols + j) as Button
                        colButton.setBackgroundResource(pressedButtonBackgroundResId)
                    }

                    //val clickedRow = row
                    //val clickedCol = col
                    pressedButtonRow = row
                    pressedButtonColumn = col
                    pressedButtonId = button.id
                    //println(pressedButtonRow)
                    //println(pressedButtonColumn)
                    println(pressedButtonId)

                    // Store a reference to the currently pressed button
                    previousButton = button
                    previousRow = row
                    previousCol = col
                }
                gridLayoutPlayfield.addView(button)
            }
        }
        //------------------------------------------------

        // Fitting array value into the buttons----------------------
        var buttonCount = 1
        for (i in 0 until gridLayoutPlayfield.rowCount) {
            for (j in 0 until gridLayoutPlayfield.columnCount) {

                val childView = gridLayoutPlayfield.getChildAt(i * gridLayoutPlayfield.columnCount + j)

                if (childView is Button) {
                    if(outputArray[i][j] == 0){
                        childView.text = " "
                    } else{
                        childView.text = outputArray[i][j].toString()
                        childView.isClickable = false
                    }
                }
                buttonCount++
            }
        }
        //-------------------------------------------------------------

        //-----------------------------------------------------
        bottonButtonOne = findViewById(R.id.buttonOne)
        bottonButtonTwo = findViewById(R.id.buttonTwo)
        bottonButtonThree = findViewById(R.id.buttonThree)
        bottonButtonFour = findViewById(R.id.buttonFour)
        bottonButtonFive = findViewById(R.id.buttonFive)
        bottonButtonSix = findViewById(R.id.buttonSix)
        bottonButtonSeven = findViewById(R.id.buttonSeven)
        bottonButtonEight = findViewById(R.id.buttonEight)
        bottonButtonNine = findViewById(R.id.buttonNine)
        bottonFinish = findViewById(R.id.buttonFinish)
        buttonHint = findViewById(R.id.buttonHint)
        bottonClear = findViewById(R.id.bottonClear)

        bottonButtonOne.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "1"
        }
        bottonButtonTwo.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "2"
        }
        bottonButtonThree.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "3"
        }
        bottonButtonFour.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "4"
        }
        bottonButtonFive.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "5"
        }
        bottonButtonSix.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "6"
        }
        bottonButtonSeven.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "7"
        }
        bottonButtonEight.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "8"
        }
        bottonButtonNine.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = "9"
        }
        bottonClear.setOnClickListener{
            val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
            button.text = ""
        }
        bottonFinish.setOnClickListener{

            val insertedArray = Array(9) { arrayOfNulls<String>(9) }

            for (i in 0 until 9){
                for (j in 0 until 9){
                    val index = i * gridLayoutPlayfield.columnCount + j
                    val button = gridLayoutPlayfield.getChildAt(index) as? Button
                    val buttonText = button?.text
                    if(buttonText != " "){
                        insertedArray[i][j] = buttonText.toString()
                    } else{
                        insertedArray[i][j] = "0"
                    }
                }
            }

            var areEqual = true


            for(i in 0 until 9){
                for(j in 0 until 9){
                    if(grid[i][j] != insertedArray[i][j]?.toInt()){
                        areEqual = false
                        break
                    }
                }
            }
            if(areEqual){
                println("Arrays are equal!")
                alertBuilder.setTitle("SUCESS!")
                    .setMessage("Good job! You solved the puzzle correctly!")
                    .setCancelable(false)
                    .setPositiveButton("Close the game") { _, _ ->
                        val intent = Intent(applicationContext, DifficultyActivity::class.java)
                        intent.putExtra("shouldClose", true)
                        startActivity(intent)
                        finishAffinity()
                    }
                    .setNeutralButton(""){ _, _ ->
                    }
                    .setNegativeButton("New game") { _, _ ->
                        val intent = Intent(this,DifficultyActivity::class.java)
                        startActivity(intent)
                    }
            } else if (!areEqual){
                println("Arrays are not equal!")
                alertBuilder.setTitle("MISTAKE!")
                    .setMessage("Unfortunately, your solution is not correct!")
                    .setCancelable(false)
                    .setPositiveButton("Keep trying") { _, _ ->
                        closeOptionsMenu()
                    }
                    .setNeutralButton("Close the game"){ _, _ ->
                        val intent = Intent(applicationContext, DifficultyActivity::class.java)
                        intent.putExtra("shouldClose", true)
                        startActivity(intent)
                        finishAffinity()
                    }
                    .setNegativeButton("New game") { _, _ ->
                        val intent = Intent(this,DifficultyActivity::class.java)
                        startActivity(intent)
                    }
            }
            val dialog = alertBuilder.create()
            dialog.show()
        }

        var messageHints : String = ""

        buttonHint.setOnClickListener{
            if(hintsRemaining <= 0){
                Toast.makeText(applicationContext,"No hints left",Toast.LENGTH_LONG).show()
            } else{
                when (hintsRemaining) {
                    1 -> {
                        messageHints = "No hints left"
                    }
                    2 -> {
                        messageHints = "1 hint left"
                    }
                    3 -> {
                        messageHints = "2 hints left"
                    }
                }
                hintsRemaining --
                Toast.makeText(applicationContext, messageHints,Toast.LENGTH_LONG).show()
                val button = gridLayoutPlayfield.getChildAt(pressedButtonId-1) as Button
                button.text = grid[pressedButtonRow][pressedButtonColumn].toString()
            }
            println("Hints remaining: $hintsRemaining")
        }
    }

    private fun removeRandomNumbers(inputArray: Array<IntArray>, numToRemove: Int): Array<IntArray> {
        val numRows = inputArray.size
        val numCols = inputArray[0].size

        // make a deep copy of the input array
        val outputArray = Array(numRows) { row ->
            IntArray(numCols) { col -> inputArray[row][col] }
        }

        // randomly choose numToRemove cells to set to 0
        repeat(numToRemove) {
            var row: Int
            var col: Int
            do {
                row = Random.nextInt(numRows)
                col = Random.nextInt(numCols)
            } while (outputArray[row][col] == 0)
            outputArray[row][col] = 0
        }

        return outputArray
    }

    private fun countSolutions(board: Array<IntArray>): Int {
        val solutions = mutableListOf<Array<IntArray>>()
        solveSudokuTest(board, solutions)
        return solutions.size
    }

    private fun solveSudokuTest(board: Array<IntArray>, solutions: MutableList<Array<IntArray>>, maxSolutions: Int = 1) {
        // Find the first empty cell (represented by a 0 value)
        var row = -1
        var col = -1
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                if (board[i][j] == 0) {
                    row = i
                    col = j
                    break
                }
            }
            if (row != -1) break
        }

        // If all cells are filled, add a copy of the board to the solutions list
        if (row == -1) {
            solutions.add(board.map { it.copyOf() }.toTypedArray())
            println("Solutions at the moment: " + solutions.size)
            if (solutions.size > maxSolutions) {
                return
            }
            return
        }

        // Try filling the empty cell with each possible value
        for (value in 1..9) {
            if (isValidMove(board, row, col, value)) {
                board[row][col] = value
                solveSudokuTest(board, solutions)
                board[row][col] = 0
            }
        }
    }

    private fun isValidMove(board: Array<IntArray>, row: Int, col: Int, value: Int): Boolean {
        // Check row and column
        for (i in 0 until 9) {
            if (board[row][i] == value || board[i][col] == value) {
                return false
            }
        }

        // Check 3x3 square
        val squareRow = row / 3 * 3
        val squareCol = col / 3 * 3
        for (i in squareRow until squareRow + 3) {
            for (j in squareCol until squareCol + 3) {
                if (board[i][j] == value) {
                    return false
                }
            }
        }

        return true
    }

    private fun generateSudokuGrid(): Array<IntArray> {

        //Declaring 2-dim array 9 to 9 and filling it with Zeroes
        val grid = Array(9) { IntArray(9) }
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                grid[i][j] = 0
            }
        }

        // Calling function to fill the grid with numbers, according to Sudoku roles
        solveSudoku(grid)

        //Printing generated grid into the run terminal
        println("Initially generated sudoku grid")
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                print("${grid[i][j]} ")
            }
            println()
        }
        return grid
    }

    private fun solveSudoku(grid: Array<IntArray>, row: Int = 0, col: Int = 0): Boolean {
        // If we've reached the end of the grid, we're done
        if (row == 9) {
            return true
        }

        // If this cell is already filled in, move to the next one
        if (grid[row][col] != 0) {
            return if (col == 8) {
                solveSudoku(grid, row + 1, 0)
            } else {
                solveSudoku(grid, row, col + 1)
            }
        }

        // Shuffle the order of the numbers to try in this cell
        val nums = (1..9).shuffled()
        for (num in nums) {
            if (isValid(grid, row, col, num)) {
                grid[row][col] = num
                if (col == 8) {
                    if (solveSudoku(grid, row + 1, 0)) {
                        return true
                    }
                } else {
                    if (solveSudoku(grid, row, col + 1)) {
                        return true
                    }
                }
                grid[row][col] = 0
            }
        }

        return false
    }

    private fun isValid(grid: Array<IntArray>, row: Int, col: Int, num: Int): Boolean {
        // Check row and column
        for (i in 0 until 9) {
            if (grid[row][i] == num || grid[i][col] == num) {
                return false
            }
        }

        // Check box
        val boxRow = row / 3 * 3
        val boxCol = col / 3 * 3
        for (i in boxRow until boxRow + 3) {
            for (j in boxCol until boxCol + 3) {
                if (grid[i][j] == num) {
                    return false
                }
            }
        }

        return true
    }

    override fun onStart(){
        super.onStart()
        Log.d("MyLogMAct", "onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.d("MyLogMAct", "onResume")
    }
    override fun onPause() {
        super.onPause()
        Log.d("MyLogMAct", "onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.d("MyLogMAct", "onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("MyLogMAct", "onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyLogMAct", "onDestroy")
    }
}



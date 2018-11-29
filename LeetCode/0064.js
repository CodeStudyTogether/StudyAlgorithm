/**
 * @param {number[][]} grid
 * @return {number}
 */
var minPathSum = function(grid) {
  var m = grid.length//宽
  var n = grid[0].length;//高
  for(var i = 0; i < m; i++){//对宽做遍历
    for(var j = 0; j < n; j++){//对高做遍历
      if(i == 0 && j != 0) grid[i][j] += grid[i][j-1];
      if(i != 0 && j == 0) grid[i][j] += grid[i-1][j];
      if (i != 0 && j != 0) grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]);//找到它的上游最小的，逐步向下
    }
  }
  return grid[m-1][n-1];
};

/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   fillboard.c                                        :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jeongmin <jeongmin@student.42seoul.>       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/05/29 17:34:13 by jeongmin          #+#    #+#             */
/*   Updated: 2022/05/30 12:26:01 by minwcho          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "fill.h"

void	set_board(int n, char **board)
{
	int		i;
	int		j;

	i = 0;
	while (i < n)
	{
		j = 0;
		while (j < n)
		{
			board[i][j] = '0';
			j++;
		}
		board[i][j] = 0;
		i++;
	}
	board[i] = 0;
}

int	posi(int i, int j, char num, char **board)		//i행과 j열에 있는 숫자들과 num 비교하여 같은 것이 없으면 1반환
{
	int	a;

	a = 0;
	while (a < 4)
	{
		if (board[i][a] == num)
			return (0);
		if (board[a][j] == num)
			return (0);
		a++;
	}
	return (1);
}

int	fill_sub(int *a, int *b, char **board, char **colrow)
{
	if (*b == 4)		//가로줄을 다 돌았으면
	{
		if (!row_up_ch(*a, board, colrow) || !row_down_ch(*a, board, colrow))		//rowup rowdown의 조건과 일치 하지 않으면 1반환
			return (1);
		*a = *a + 1;
		*b = 0;		//하나의 행을 다 돌았으므로 행 + 1, 열 0으로 초기화
	}
	if (*a == 4)		//끝까지 다 돌았으면
	{
		if (col_up_ch(board, colrow) && col_down_ch(board, colrow))		//모든 열의 colup coldown의 조건과 일치하면 출력 후 2반환
		{
			print_board(board);
			return (2);
		}
		return (1);		//일치하지 않으면 1반환
	}
	return (0);		//다음으로 넘어갈 수 있으면 0반환
}

int	fill(int a, int b, char **board, char **colrow)
{
	char	k;
	int		re;

	re = fill_sub(&a, &b, board, colrow);
	if (re)
		return (re);		//fill_sub반환값이 0(다음으로 넘어갈수 있음)이 아니면 재귀 종료
	k = '1';
	if (board[a][b] == '0')		//[a][b]에 값이 없으면
	{
		while (k <= '4')		//1부터 4까지 [a][b]에 넣어보기
		{
			if (posi(a, b, k, board))		//posi함수가 참이면
			{
				board[a][b] = k;
				re = fill(a, b + 1, board, colrow);		//[a][b]에 k 넣어주고 [a][b+1]로 이동
				if (re == 2)
					return (re);		//값을 출력해줬다면 재귀 종료
				board[a][b] = '0';		//[a][b]에 다음 수 넣을 준비
			}
			k++;
		}
	}
	else
		re = fill(a, b + 1, board, colrow);		//[a][b]에 값이 있으면 바로 [a][b+1]로 이동
	return (re);
}

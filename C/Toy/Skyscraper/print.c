/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   print.c                                            :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jeongmin <jeongmin@student.42seoul.>       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/05/29 17:34:26 by jeongmin          #+#    #+#             */
/*   Updated: 2022/05/30 12:36:12 by minwcho          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <unistd.h>

int	row_up_ch(int i, char **board, char **colrow)		//rowup조건과 부합하게 들어갔는지 확인
{
	int		cnt;
	char	sum;
	int		j;

	sum = '0';
	j = -1;
	cnt = 0;
	while (++j < 4)
	{
		if (board[i][j] > sum)		//sum보다 [i][j]가 크면 sum에 [i][j]값 저장 후 cnt증가
		{
			sum = board[i][j];
			cnt++;
		}
	}
	if (cnt + '0' != colrow[i][2])		//cnt값이 rowup과 다를 경우 0반환
		return (0);
	return (1);		//일치하면 1반환
}

int	row_down_ch(int i, char **board, char **colrow)		//rowdown조건과 부합하게 들어갔는지 확인
{
	int		cnt;
	char	sum;
	int		j;

	j = 4;
	cnt = 0;
	sum = '0';
	while (--j >= 0)
	{
		if (board[i][j] > sum)
		{
			sum = board[i][j];
			cnt++;
		}
	}
	if (cnt + '0' != colrow[i][3])
		return (0);
	return (1);
}

int	col_up_ch(char **board, char **colrow)		//colup조건과 부합하게 들어갔는지 확인
{
	int		i;
	int		j;
	int		cnt;
	char	sum;

	j = -1;
	while (++j < 4)
	{
		i = -1;
		cnt = 0;
		sum = '0';
		while (++i < 4)
		{
			if (board[i][j] > sum)
			{
				sum = board[i][j];
				cnt++;
			}
		}
		if (cnt + '0' != colrow[j][0])
			return (0);
	}
	return (1);
}

int	col_down_ch(char **board, char **colrow)		//coldown조건과 부합하게 들어갔는지 확인
{
	int		i;
	int		j;
	int		cnt;
	char	sum;

	j = 0;
	while (j < 4)
	{
		i = 4;
		cnt = 0;
		sum = '0';
		while (--i >= 0)
		{
			if (board[i][j] > sum)
			{
				sum = board[i][j];
				cnt++;
			}
		}
		if (cnt + '0' != colrow[j][1])
			return (0);
		j++;
	}
	return (1);
}

void	print_board(char **board)
{
	int	i;
	int	j;

	i = 0;
	while (i < 4)
	{
		j = 0;
		while (j < 4)
		{
			write(1, &board[i][j], 1);
			if (j != 3)
				write(1, " ", 1);
			j++;
		}
		write(1, "\n", 1);
		i++;
	}
}

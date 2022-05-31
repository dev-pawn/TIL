/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   putsure.c                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jeongmin <jeongmin@student.42seoul.>       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/05/29 17:34:29 by jeongmin          #+#    #+#             */
/*   Updated: 2022/05/30 12:39:23 by minwcho          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

void	check_col_up(char **board, char **colrow)		//colup으로 유추할 수 있는 확실한 값 넣기
{
	int		i;
	int		j;
	char	n;

	i = 0;
	while (i < 4)
	{
		if (colrow[i][0] == '4')		//colup[i]가 4면 1부터 4까지 i열에 넣어줌
		{
			n = '1';
			j = -1;
			while (++j < 4)
				board[j][i] = n++;
		}
		else if ((colrow[i][0] - '0') + (colrow[i][1] - '0') == 5)		//colup+coldown이 5면 특정한자리에 4 넣어줌
			board[colrow[i][0] - '0' - 1][i] = '4';
		else if (colrow[i][0] == '1')		//colup[i]가 1이면 4 넣어줌
			board[0][i] = '4';
		i++;
	}
}

void	check_col_down(char **board, char **colrow)		//coldown으로 유추할 수 있는 확실한 값 넣기
{
	int		i;
	int		j;
	char	n;

	i = 0;
	while (i < 4)
	{
		if (colrow[i][1] == '4')
		{
			n = '1';
			j = 4;
			while (--j >= 0)
				board[j][i] = n++;
		}
		else if (colrow[i][1] == '1')
			board[3][i] = '4';
		i++;
	}
}

void	check_row_up(char **board, char **colrow)		//rowup으로 유추할 수 있는 확실한 값 넣기
{
	int		i;
	int		j;
	char	n;

	i = 0;
	while (i < 4)
	{
		if (colrow[i][2] == '4')
		{
			n = '1';
			j = -1;
			while (++j < 4)
				board[i][j] = n++;
		}
		else if ((colrow[i][2] - '0') + (colrow[i][3] - '0') == 5)
			board[i][colrow[i][2] - '0' - 1] = '4';
		else if (colrow[i][2] == '1')
			board[i][0] = '4';
		i++;
	}
}

void	check_row_down(char **board, char **colrow)		//rowdown으로 유추할 수 있는 확실한 값 넣기
{
	int		i;
	int		j;
	char	n;

	i = 0;
	while (i < 4)
	{
		if (colrow[i][3] == '4')
		{
			n = '1';
			j = 4;
			while (--j >= 0)
				board[i][j] = n++;
		}
		else if (colrow[i][3] == '1')
			board[i][3] = '4';
		i++;
	}
}

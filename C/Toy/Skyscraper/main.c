/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   main.c                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jeongmin <jeongmin@student.42seoul.>       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/05/29 17:34:19 by jeongmin          #+#    #+#             */
/*   Updated: 2022/05/30 12:33:12 by minwcho          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include "main.h"

void	put_num(char **argv, char *num)		//입력받은 인자 중 숫자만 뽑아오기
{
	int	i;
	int	j;

	i = 0;
	j = 0;
	while (argv[1][j])
	{
		if (argv[1][j] >= '0' && argv[1][j] <= '4')
		{
			num[i] = argv[1][j];
			i++;
			j++;
		}
		else
			j++;
	}
}

void	set_colrow(char **colrow, char *num)		//뽑아온 숫자를 rowup rowdown colup coldown에 각각 넣어주기
{
	int	i;

	i = 0;
	while (i < 4)
	{
		colrow[i][0] = num[i];		//colup
		colrow[i][1] = num[i + 4];		//coldown
		colrow[i][2] = num[i + 8];		//rowup
		colrow[i][3] = num[i + 12];		//rowdown
		i++;
	}
}

int	error(int argc, char *argv[])		//입력값이 옳지 않으면 에러 반환
{
	int	i;
	int	cnt;

	i = 0;
	cnt = 0;
	if (argc != 2)		//인자를 하나만 받지 않았으면 1반환
		return (1);
	while (argv[1][i])
	{
		if (argv[1][i] >= '0' && argv[1][i] <= '4')
		{
			if (argv[1][i + 1] >= '0' && argv[1][i + 1] <= '4')		//숫자가 연속으로 입력되었으면 1반환
				return (1);
			cnt++;
			i++;
		}
		else if (argv[1][i] == ' ' || argv[1][i] == '\n' || argv[1][i] == '\t')
			i++;
		else
			return (1);		//숫자와 공백문자가 아닌 값들이 입력되면 1반환
	}
	if (cnt != 16)		//입력받은 숫자의 개수가 16(4*4기준)이 아니면 1반환
		return (1);
	return (0);		//옳으면 0반환
}

void	execute(char **colrow, char **board)
{
	set_board(4, board);		//board를 '0'으로 초기화
	check_col_up(board, colrow);		//colup으로 유추할 수 있는 확실한 수 넣기
	check_col_down(board, colrow);		//coldown으로 유추할 수 있는 확실한 수 넣기
	check_row_up(board, colrow);		//rowup으로 유추할 수 있는 확실한 수 넣기
	check_row_down(board, colrow);		//rowdown으로 유추할 수 있는 확실한 수 넣기
	if (fill(0, 0, board, colrow) != 2)		//fill의 반환값이 2(출력했을경우)가 아니면 error
		write(1, "Error\n", 6);
}

int	main(int argc, char *argv[])
{
	char	**board;
	char	**colrow;
	char	*num;

	if (error(argc, argv))		//에러출력
	{
		write(1, "Error\n", 6);
		return (0);
	}
	if (init(&colrow, &board, &num))		//메모리부족으로 메모리할당을 받지 못했을 경우
	{
		write(1, "Memory Leak\n", 12);
		return (0);
	}
	put_num(argv, num);		//입력값 중 숫자듦만 num배열에 저장
	set_colrow(colrow, num);		//num배열안의 값들을 colrow로 이동
	execute(colrow, board);		//정답 출력
	memory_free(&board, &colrow, &num);
	return (0);
}

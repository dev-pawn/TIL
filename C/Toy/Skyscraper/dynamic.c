/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   dynamic.c                                          :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jeongmin <jeongmin@student.42seoul.>       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/05/29 17:34:02 by jeongmin          #+#    #+#             */
/*   Updated: 2022/05/29 23:25:48 by jeongmin         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#include <stdlib.h>

void	free_two_array(char ***str, int n)
{
	int	i;

	i = 0;
	while (i < n)
	{
		free((*str)[i]);
		i++;
	}
	free(*str);
	*str = 0;
}

void	memory_free(char ***board, char ***colrow, char **num)
{
	free_two_array(colrow, 4);
	free_two_array(board, 4);
	free(*num);
	*num = 0;
}

int	init_colrow(char ***colrow)
{
	int	i;

	i = 0;
	while (i < 4)
	{
		(*colrow)[i] = (char *)malloc(sizeof(char) * 5);
		if ((*colrow)[i] == 0)
		{
			free_two_array(colrow, i);
			return (1);
		}
		i++;
	}
	(*colrow)[i] = 0;
	return (0);
}

int	init_sub(char ***board, char ***colrow)
{
	int	i;

	i = 0;
	while (i < 4)
	{
		(*board)[i] = (char *)malloc(sizeof(char) * 5);
		if ((*board)[i] == 0)
		{
			free_two_array(board, i);
			free_two_array(colrow, 4);
			return (1);
		}
		i++;
	}
	(*board)[i] = 0;
	return (0);
}

int	init(char ***colrow, char ***board, char **num)
{
	(*colrow) = (char **)malloc(sizeof(char *) * 5);
	if (*colrow == 0 || init_colrow(colrow))
		return (1);
	(*board) = (char **)malloc(sizeof(char *) * 5);
	if (*board == 0)
	{
		free_two_array(colrow, 4);
		return (1);
	}
	if (init_sub(board, colrow))
		return (1);
	(*num) = (char *)malloc(sizeof(char) * 17);
	if (*num == 0)
	{
		free_two_array(board, 4);
		free_two_array(colrow, 4);
		return (1);
	}
	return (0);
}

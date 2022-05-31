/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   main.h                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jeongmin <jeongmin@student.42seoul.>       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/05/29 17:34:35 by jeongmin          #+#    #+#             */
/*   Updated: 2022/05/30 12:33:16 by minwcho          ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#ifndef MAIN_H
# define MAIN_H
# include <unistd.h>

void	set_board(int n, char **board);
void	check_col_up(char **board, char **colrow);
void	check_col_down(char **board, char **colrow);
void	check_row_up(char **board, char **colrow);
void	check_row_down(char **board, char **colrow);
int		fill(int a, int b, char **board, char **colrow);
int		init(char ***colrow, char ***board, char **num);
void	free_two_array(char ***str, int n);
void	memory_free(char ***board, char ***colrow, char **num);
int		init_colrow(char ***colrow);
int		init_sub(char ***board, char ***colrow);

#endif

/* ************************************************************************** */
/*                                                                            */
/*                                                        :::      ::::::::   */
/*   fill.h                                             :+:      :+:    :+:   */
/*                                                    +:+ +:+         +:+     */
/*   By: jeongmin <jeongmin@student.42seoul.>       +#+  +:+       +#+        */
/*                                                +#+#+#+#+#+   +#+           */
/*   Created: 2022/05/29 17:34:40 by jeongmin          #+#    #+#             */
/*   Updated: 2022/05/29 17:35:03 by jeongmin         ###   ########.fr       */
/*                                                                            */
/* ************************************************************************** */

#ifndef FILL_H
# define FILL_H

int		row_up_ch(int i, char **board, char **colrow);
int		row_down_ch(int i, char **board, char **colrow);
int		col_up_ch(char **board, char **colrow);
int		col_down_ch(char **board, char **colrow);
void	print_board(char **board);

#endif
